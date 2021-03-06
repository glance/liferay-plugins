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

package com.liferay.hr.model.impl;

import com.liferay.hr.model.HRUser;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.util.Date;

/**
 * The cache model class for representing HRUser in entity cache.
 *
 * @author Wesley Gong
 * @see HRUser
 * @generated
 */
public class HRUserCacheModel implements CacheModel<HRUser> {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{hrUserId=");
		sb.append(hrUserId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", hrEmploymentTypeId=");
		sb.append(hrEmploymentTypeId);
		sb.append(", hrJobTitleId=");
		sb.append(hrJobTitleId);
		sb.append(", hrOfficeId=");
		sb.append(hrOfficeId);
		sb.append(", hrTerminationTypeId=");
		sb.append(hrTerminationTypeId);
		sb.append(", hrWageTypeId=");
		sb.append(hrWageTypeId);
		sb.append(", hireDate=");
		sb.append(hireDate);
		sb.append(", terminationDate=");
		sb.append(terminationDate);
		sb.append(", wageAmount=");
		sb.append(wageAmount);
		sb.append(", wageCurrencyCode=");
		sb.append(wageCurrencyCode);
		sb.append(", benefitsExempt=");
		sb.append(benefitsExempt);
		sb.append(", overtimeExempt=");
		sb.append(overtimeExempt);
		sb.append("}");

		return sb.toString();
	}

	public HRUser toEntityModel() {
		HRUserImpl hrUserImpl = new HRUserImpl();

		hrUserImpl.setHrUserId(hrUserId);
		hrUserImpl.setGroupId(groupId);
		hrUserImpl.setCompanyId(companyId);
		hrUserImpl.setUserId(userId);

		if (userName == null) {
			hrUserImpl.setUserName(StringPool.BLANK);
		}
		else {
			hrUserImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			hrUserImpl.setCreateDate(null);
		}
		else {
			hrUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			hrUserImpl.setModifiedDate(null);
		}
		else {
			hrUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		hrUserImpl.setHrEmploymentTypeId(hrEmploymentTypeId);
		hrUserImpl.setHrJobTitleId(hrJobTitleId);
		hrUserImpl.setHrOfficeId(hrOfficeId);
		hrUserImpl.setHrTerminationTypeId(hrTerminationTypeId);
		hrUserImpl.setHrWageTypeId(hrWageTypeId);

		if (hireDate == Long.MIN_VALUE) {
			hrUserImpl.setHireDate(null);
		}
		else {
			hrUserImpl.setHireDate(new Date(hireDate));
		}

		if (terminationDate == Long.MIN_VALUE) {
			hrUserImpl.setTerminationDate(null);
		}
		else {
			hrUserImpl.setTerminationDate(new Date(terminationDate));
		}

		hrUserImpl.setWageAmount(wageAmount);

		if (wageCurrencyCode == null) {
			hrUserImpl.setWageCurrencyCode(StringPool.BLANK);
		}
		else {
			hrUserImpl.setWageCurrencyCode(wageCurrencyCode);
		}

		hrUserImpl.setBenefitsExempt(benefitsExempt);
		hrUserImpl.setOvertimeExempt(overtimeExempt);

		hrUserImpl.resetOriginalValues();

		return hrUserImpl;
	}

	public long hrUserId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long hrEmploymentTypeId;
	public long hrJobTitleId;
	public long hrOfficeId;
	public long hrTerminationTypeId;
	public long hrWageTypeId;
	public long hireDate;
	public long terminationDate;
	public double wageAmount;
	public String wageCurrencyCode;
	public boolean benefitsExempt;
	public boolean overtimeExempt;
}