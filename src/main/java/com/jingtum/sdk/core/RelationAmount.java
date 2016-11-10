/*
 * Copyright www.jingtum.com Inc. 
 * 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.jingtum.sdk.core;

import com.google.gson.annotations.Expose;
import com.jingtum.sdk.ERROR;
import com.jingtum.sdk.exception.InvalidParameterException;
import com.jingtum.sdk.utils.Utils;

/**
 * Used in relations API
 * 
 * @author jzhao
 * @version 1.0
 */
public class RelationAmount extends JingtumObject {
	@Expose
	private double limit;
	@Expose
	private String currency;
	@Expose
	private String issuer;

	/**
	 * Limit, used in adding relation
	 * 
	 * @param limit
	 * @throws InvalidParameterException
	 */
	public void setLimit(double limit) throws InvalidParameterException {
		if (limit < 0) {
			throw new InvalidParameterException(ERROR.INVALID_LIMIT, currency, null);
		}
		this.limit = limit;
	}

	/**
	 * Get limit
	 * 
	 * @return limit
	 */
	public double getLimit() {
		return limit;
	}

	/**
	 * Get currency
	 * 
	 * @return currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Set currency
	 * 
	 * @param currency
	 * @throws InvalidParameterException
	 */
	public void setCurrency(String currency) throws InvalidParameterException {
		if (!Utils.isValidCurrency(currency)) {
			throw new InvalidParameterException(ERROR.INVALID_CURRENCY, currency, null);
		}
		this.currency = currency;
	}

	/**
	 * Get issuer
	 * 
	 * @return issuer
	 */
	public String getIssuer() {
		return issuer;
	}

	/**
	 * Set issuer
	 * 
	 * @param issuer
	 * @throws InvalidParameterException
	 */
	public void setIssuer(String issuer) throws InvalidParameterException {
		if (issuer != "" && !Utils.isValidAddress(issuer)) {
			throw new InvalidParameterException(ERROR.INVALID_JINGTUM_ADDRESS, issuer, null);
		}
		this.issuer = issuer;
	}
}
