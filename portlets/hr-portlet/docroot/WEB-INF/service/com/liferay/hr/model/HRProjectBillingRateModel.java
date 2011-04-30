/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.hr.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the HRProjectBillingRate service. Represents a row in the &quot;HRProjectBillingRate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.hr.model.impl.HRProjectBillingRateModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.hr.model.impl.HRProjectBillingRateImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HRProjectBillingRate
 * @see com.liferay.hr.model.impl.HRProjectBillingRateImpl
 * @see com.liferay.hr.model.impl.HRProjectBillingRateModelImpl
 * @generated
 */
public interface HRProjectBillingRateModel extends BaseModel<HRProjectBillingRate>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a h r project billing rate model instance should use the {@link HRProjectBillingRate} interface instead.
	 */

	/**
	 * Gets the primary key of this h r project billing rate.
	 *
	 * @return the primary key of this h r project billing rate
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this h r project billing rate
	 *
	 * @param pk the primary key of this h r project billing rate
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the hr project billing rate ID of this h r project billing rate.
	 *
	 * @return the hr project billing rate ID of this h r project billing rate
	 */
	public long getHrProjectBillingRateId();

	/**
	 * Sets the hr project billing rate ID of this h r project billing rate.
	 *
	 * @param hrProjectBillingRateId the hr project billing rate ID of this h r project billing rate
	 */
	public void setHrProjectBillingRateId(long hrProjectBillingRateId);

	/**
	 * Gets the group ID of this h r project billing rate.
	 *
	 * @return the group ID of this h r project billing rate
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this h r project billing rate.
	 *
	 * @param groupId the group ID of this h r project billing rate
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company ID of this h r project billing rate.
	 *
	 * @return the company ID of this h r project billing rate
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this h r project billing rate.
	 *
	 * @param companyId the company ID of this h r project billing rate
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user ID of this h r project billing rate.
	 *
	 * @return the user ID of this h r project billing rate
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this h r project billing rate.
	 *
	 * @param userId the user ID of this h r project billing rate
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this h r project billing rate.
	 *
	 * @return the user uuid of this h r project billing rate
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this h r project billing rate.
	 *
	 * @param userUuid the user uuid of this h r project billing rate
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this h r project billing rate.
	 *
	 * @return the user name of this h r project billing rate
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this h r project billing rate.
	 *
	 * @param userName the user name of this h r project billing rate
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this h r project billing rate.
	 *
	 * @return the create date of this h r project billing rate
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this h r project billing rate.
	 *
	 * @param createDate the create date of this h r project billing rate
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this h r project billing rate.
	 *
	 * @return the modified date of this h r project billing rate
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this h r project billing rate.
	 *
	 * @param modifiedDate the modified date of this h r project billing rate
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the hr project ID of this h r project billing rate.
	 *
	 * @return the hr project ID of this h r project billing rate
	 */
	public long getHrProjectId();

	/**
	 * Sets the hr project ID of this h r project billing rate.
	 *
	 * @param hrProjectId the hr project ID of this h r project billing rate
	 */
	public void setHrProjectId(long hrProjectId);

	/**
	 * Gets the hr project role ID of this h r project billing rate.
	 *
	 * @return the hr project role ID of this h r project billing rate
	 */
	public long getHrProjectRoleId();

	/**
	 * Sets the hr project role ID of this h r project billing rate.
	 *
	 * @param hrProjectRoleId the hr project role ID of this h r project billing rate
	 */
	public void setHrProjectRoleId(long hrProjectRoleId);

	/**
	 * Gets the rate of this h r project billing rate.
	 *
	 * @return the rate of this h r project billing rate
	 */
	public double getRate();

	/**
	 * Sets the rate of this h r project billing rate.
	 *
	 * @param rate the rate of this h r project billing rate
	 */
	public void setRate(double rate);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(HRProjectBillingRate hrProjectBillingRate);

	public int hashCode();

	public HRProjectBillingRate toEscapedModel();

	public String toString();

	public String toXmlString();
}