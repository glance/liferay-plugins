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

package com.liferay.hr.service.persistence;

import com.liferay.hr.model.HRExpenseCurrency;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the h r expense currency service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Wesley Gong
 * @see HRExpenseCurrencyPersistenceImpl
 * @see HRExpenseCurrencyUtil
 * @generated
 */
public interface HRExpenseCurrencyPersistence extends BasePersistence<HRExpenseCurrency> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HRExpenseCurrencyUtil} to access the h r expense currency persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the h r expense currency in the entity cache if it is enabled.
	*
	* @param hrExpenseCurrency the h r expense currency
	*/
	public void cacheResult(
		com.liferay.hr.model.HRExpenseCurrency hrExpenseCurrency);

	/**
	* Caches the h r expense currencies in the entity cache if it is enabled.
	*
	* @param hrExpenseCurrencies the h r expense currencies
	*/
	public void cacheResult(
		java.util.List<com.liferay.hr.model.HRExpenseCurrency> hrExpenseCurrencies);

	/**
	* Creates a new h r expense currency with the primary key. Does not add the h r expense currency to the database.
	*
	* @param hrExpenseCurrencyId the primary key for the new h r expense currency
	* @return the new h r expense currency
	*/
	public com.liferay.hr.model.HRExpenseCurrency create(
		long hrExpenseCurrencyId);

	/**
	* Removes the h r expense currency with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hrExpenseCurrencyId the primary key of the h r expense currency
	* @return the h r expense currency that was removed
	* @throws com.liferay.hr.NoSuchExpenseCurrencyException if a h r expense currency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.hr.model.HRExpenseCurrency remove(
		long hrExpenseCurrencyId)
		throws com.liferay.hr.NoSuchExpenseCurrencyException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.hr.model.HRExpenseCurrency updateImpl(
		com.liferay.hr.model.HRExpenseCurrency hrExpenseCurrency, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the h r expense currency with the primary key or throws a {@link com.liferay.hr.NoSuchExpenseCurrencyException} if it could not be found.
	*
	* @param hrExpenseCurrencyId the primary key of the h r expense currency
	* @return the h r expense currency
	* @throws com.liferay.hr.NoSuchExpenseCurrencyException if a h r expense currency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.hr.model.HRExpenseCurrency findByPrimaryKey(
		long hrExpenseCurrencyId)
		throws com.liferay.hr.NoSuchExpenseCurrencyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the h r expense currency with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param hrExpenseCurrencyId the primary key of the h r expense currency
	* @return the h r expense currency, or <code>null</code> if a h r expense currency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.hr.model.HRExpenseCurrency fetchByPrimaryKey(
		long hrExpenseCurrencyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the h r expense currencies.
	*
	* @return the h r expense currencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.hr.model.HRExpenseCurrency> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the h r expense currencies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of h r expense currencies
	* @param end the upper bound of the range of h r expense currencies (not inclusive)
	* @return the range of h r expense currencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.hr.model.HRExpenseCurrency> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the h r expense currencies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of h r expense currencies
	* @param end the upper bound of the range of h r expense currencies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of h r expense currencies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.hr.model.HRExpenseCurrency> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the h r expense currencies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of h r expense currencies.
	*
	* @return the number of h r expense currencies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public HRExpenseCurrency remove(HRExpenseCurrency hrExpenseCurrency)
		throws SystemException;
}