/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.knowledgebase.admin.util;

import com.liferay.documentlibrary.service.DLLocalServiceUtil;
import com.liferay.knowledgebase.model.Article;
import com.liferay.knowledgebase.service.ArticleLocalServiceUtil;
import com.liferay.knowledgebase.service.permission.ArticlePermission;
import com.liferay.knowledgebase.util.KnowledgeBaseUtil;
import com.liferay.knowledgebase.util.PortletKeys;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TextFormatter;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.Subscription;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.SubscriptionSender;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

import java.util.Locale;

import javax.mail.internet.InternetAddress;

/**
 * @author Peter Shin
 * @author Brian Wing Shun Chan
 */
public class AdminSubscriptionSender extends SubscriptionSender {

	public AdminSubscriptionSender(Article article, String portalURL) {
		_article = article;
		_portalURL = portalURL;
	}

	protected void deleteSubscription(Subscription subscription)
		throws Exception {

		ArticleLocalServiceUtil.unsubscribeAllPortlets(
			subscription.getCompanyId(), subscription.getSubscriptionId());
	}

	protected boolean hasPermission(Subscription subscription, User user)
		throws Exception {

		PrincipalThreadLocal.setName(user.getUserId());

		try {
			PermissionChecker permissionChecker =
				PermissionCheckerFactoryUtil.create(user, true);

			PermissionThreadLocal.setPermissionChecker(permissionChecker);

			if (!ArticlePermission.contains(
					permissionChecker, _article, ActionKeys.VIEW)) {

				return false;
			}
		}
		finally {
			PrincipalThreadLocal.setName(null);

			PermissionThreadLocal.setPermissionChecker(null);
		}

		String[] portletIds = ExpandoValueLocalServiceUtil.getData(
			user.getCompanyId(), Subscription.class.getName(), "KB",
			"portletIds", subscription.getSubscriptionId(), new String[0]);

		for (String portletId : portletIds) {
			String articleURL = KnowledgeBaseUtil.getArticleURL(
				portletId, _article.getResourcePrimKey(), _portalURL);

			if (Validator.isNotNull(articleURL)) {
				context.put("articleURL", articleURL);

				return true;
			}

			if (_log.isInfoEnabled()) {
				_log.info(
					"Portlet " + portletId + " does not exist or does " +
						"not contain " + _article.getResourcePrimKey());
			}

			ArticleLocalServiceUtil.unsubscribe(
				subscription.getCompanyId(), userId, portletId,
				subscription.getClassPK());
		}

		return false;
	}

	protected void processMailMessage(MailMessage mailMessage, Locale locale)
		throws Exception {

		super.processMailMessage(mailMessage, locale);

		InternetAddress from = mailMessage.getFrom();

		String categoryTitle = LanguageUtil.get(locale, "category.kb");
		String portletName = PortalUtil.getPortletTitle(
			PortletKeys.KNOWLEDGE_BASE_ADMIN, locale);

		String processedFromAddress = StringUtil.replace(
			from.getAddress(),
			new String[] {
				"[$CATEGORY_TITLE$]",
				"[$PORTLET_NAME$]"
			},
			new String[] {
				categoryTitle,
				portletName
			});

		String processedFromName = StringUtil.replace(
			from.getPersonal(),
			new String[] {
				"[$CATEGORY_TITLE$]",
				"[$PORTLET_NAME$]"
			},
			new String[] {
				categoryTitle,
				portletName
			});

		InternetAddress processedFrom = new InternetAddress(
			processedFromAddress, processedFromName);

		mailMessage.setFrom(processedFrom);

		String articleAttachments = getEmailArticleAttachments(
			_article, locale);
		String articleURL = (String)context.get("articleURL");
		String articleVersion = LanguageUtil.format(
			locale, "version-x", String.valueOf(_article.getVersion()));

		String processedSubject = StringUtil.replace(
			mailMessage.getSubject(),
			new String[] {
				"[$ARTICLE_ATTACHMENTS$]",
				"[$ARTICLE_URL$]",
				"[$ARTICLE_VERSION$]",
				"[$CATEGORY_TITLE$]",
				"[$PORTLET_NAME$]"
			},
			new String[] {
				articleAttachments,
				articleURL,
				articleVersion,
				categoryTitle,
				portletName
			});

		mailMessage.setSubject(processedSubject);

		String processedBody = StringUtil.replace(
			mailMessage.getBody(),
			new String[] {
				"[$ARTICLE_ATTACHMENTS$]",
				"[$ARTICLE_URL$]",
				"[$ARTICLE_VERSION$]",
				"[$CATEGORY_TITLE$]",
				"[$PORTLET_NAME$]"
			},
			new String[] {
				articleAttachments,
				articleURL,
				articleVersion,
				categoryTitle,
				portletName
			});

		mailMessage.setBody(processedBody);
	}

	protected String getEmailArticleAttachments(Article article, Locale locale)
		throws Exception {

		String[] fileNames = article.getAttachmentsFileNames();

		if (fileNames.length <= 0) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler(fileNames.length * 5);

		for (String fileName : fileNames) {
			long kb = DLLocalServiceUtil.getFileSize(
				article.getCompanyId(), CompanyConstants.SYSTEM, fileName);

			sb.append(FileUtil.getShortFileName(fileName));
			sb.append(" (");
			sb.append(TextFormatter.formatKB(kb, locale));
			sb.append("k)");
			sb.append("<br />");
		}

		return sb.toString();
	}

	private static Log _log = LogFactoryUtil.getLog(
		AdminSubscriptionSender.class);

	private Article _article;
	private String _portalURL;

}