/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */



/**
 * User
 *
 */

import java.util.Collection;
import java.util.Date;

public class VXUser  {
	/*private static final long serialVersionUID = 1L;
	*/
	protected Long id;
	protected Date createDate;
	protected Date updateDate;
	/**
	 * Name
	 */
	protected String name;
	/**
	 * First Name
	 */
	protected String firstName;
	/**
	 * Last Name
	 */
	protected String lastName;
	/**
	 * Email address
	 */
	protected String emailAddress;
	/**
	 * Password
	 */
	protected String password;
	/**
	 * Description
	 */
	protected String description;
	/**
	 * Id of the credential store
	 */
	protected Long credStoreId;
	/**
	 * List of group ids
	 */
	protected Collection<Long> groupIdList;
	protected Collection<String> groupNameList;
	
	protected int status;
	protected Integer isVisible;
	protected String owner;
	protected int userSource;
	/**
	 * List of roles for this user
	 */
	protected Collection<String> userRoleList;

	/**
	 * Default constructor. This will set all the attributes to default value.
	 */

	/**
	 * This method sets the value to the member attribute <b>name</b>.
	 * You cannot set null to the attribute.
	 * @param name Value to set member attribute <b>name</b>
	 */
	public void setName( String name ) {
		this.name = name;
	}

	/**
	 * Returns the value for the member attribute <b>name</b>
	 * @return String - value of member attribute <b>name</b>.
	 */
	public String getName( ) {
		return this.name;
	}

	/**
	 * This method sets the value to the member attribute <b>firstName</b>.
	 * You cannot set null to the attribute.
	 * @param firstName Value to set member attribute <b>firstName</b>
	 */
	public void setFirstName( String firstName ) {
		this.firstName = firstName;
	}

	/**
	 * Returns the value for the member attribute <b>firstName</b>
	 * @return String - value of member attribute <b>firstName</b>.
	 */
	public String getFirstName( ) {
		return this.firstName;
	}

	/**
	 * This method sets the value to the member attribute <b>lastName</b>.
	 * You cannot set null to the attribute.
	 * @param lastName Value to set member attribute <b>lastName</b>
	 */
	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}

	/**
	 * Returns the value for the member attribute <b>lastName</b>
	 * @return String - value of member attribute <b>lastName</b>.
	 */
	public String getLastName( ) {
		return this.lastName;
	}

	/**
	 * This method sets the value to the member attribute <b>emailAddress</b>.
	 * You cannot set null to the attribute.
	 * @param emailAddress Value to set member attribute <b>emailAddress</b>
	 */
	public void setEmailAddress( String emailAddress ) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Returns the value for the member attribute <b>emailAddress</b>
	 * @return String - value of member attribute <b>emailAddress</b>.
	 */
	public String getEmailAddress( ) {
		return this.emailAddress;
	}

	/**
	 * This method sets the value to the member attribute <b>password</b>.
	 * You cannot set null to the attribute.
	 * @param password Value to set member attribute <b>password</b>
	 */
	public void setPassword( String password ) {
		this.password = password;
	}

	/**
	 * Returns the value for the member attribute <b>password</b>
	 * @return String - value of member attribute <b>password</b>.
	 */
	public String getPassword( ) {
		return this.password;
	}

	/**
	 * This method sets the value to the member attribute <b>description</b>.
	 * You cannot set null to the attribute.
	 * @param description Value to set member attribute <b>description</b>
	 */
	public void setDescription( String description ) {
		this.description = description;
	}

	/**
	 * Returns the value for the member attribute <b>description</b>
	 * @return String - value of member attribute <b>description</b>.
	 */
	public String getDescription( ) {
		return this.description;
	}

	/**
	 * This method sets the value to the member attribute <b>credStoreId</b>.
	 * You cannot set null to the attribute.
	 * @param credStoreId Value to set member attribute <b>credStoreId</b>
	 */
	public void setCredStoreId( Long credStoreId ) {
		this.credStoreId = credStoreId;
	}

	/**
	 * Returns the value for the member attribute <b>credStoreId</b>
	 * @return Long - value of member attribute <b>credStoreId</b>.
	 */
	public Long getCredStoreId( ) {
		return this.credStoreId;
	}

	/**
	 * This method sets the value to the member attribute <b>groupIdList</b>.
	 * You cannot set null to the attribute.
	 * @param groupIdList Value to set member attribute <b>groupIdList</b>
	 */
	public void setGroupIdList( Collection<Long> groupIdList ) {
		this.groupIdList = groupIdList;
	}

	/**
	 * Returns the value for the member attribute <b>groupIdList</b>
	 * @return Collection<Long> - value of member attribute <b>groupIdList</b>.
	 */
	public Collection<Long> getGroupIdList( ) {
		return this.groupIdList;
	}

	/**
	 * This method sets the value to the member attribute <b>id</b>.
	 * You cannot set null to the attribute.
	 * @param id Value to set member attribute <b>id</b>
	 */
	public void setId( Long id ) {
		this.id = id;
	}

	/**
	 * Returns the value for the member attribute <b>id</b>
	 * @return Long - value of member attribute <b>id</b>.
	 */
	public Long getId( ) {
		return this.id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getIsVisible() {
		return isVisible;
	}
	
	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}

	public int getUserSource() {
		return userSource;
	}

	public void setUserSource(int userSource) {
		this.userSource = userSource;
	}
	
	/**
	 * This method sets the value to the member attribute <b>userRoleList</b>.
	 * You cannot set null to the attribute.
	 * @param userRoleList Value to set member attribute <b>userRoleList</b>
	 */
	public void setUserRoleList( Collection<String> userRoleList ) {
		this.userRoleList = userRoleList;
	}

	/**
	 * Returns the value for the member attribute <b>userRoleList</b>
	 * @return Collection<String> - value of member attribute <b>userRoleList</b>.
	 */
	public Collection<String> getUserRoleList( ) {
		return this.userRoleList;
	}

	
	public Collection<String> getGroupNameList() {
		return groupNameList;
	}
	 /**
     * This method sets the value to the member attribute <b>owner</b>.
     * You cannot set null to the attribute.
     * @param owner Value to set member attribute <b>owner</b>
     */
    public void setOwner( String owner ) {
            this.owner = owner;
    }

	public void setGroupNameList(Collection<String> groupNameList) {
		this.groupNameList = groupNameList;
	}
	public void setCreateDate(Date createDate ) {
		this.createDate = createDate;
	}

	public Date getCreateDate( ) {
		return this.createDate;
	}
	
	public void setUpdateDate( Date updateDate ) {
		this.updateDate = updateDate;
	}

	/**
	 * Returns the value for the member attribute <b>updateDate</b>
	 * @return Date - value of member attribute <b>updateDate</b>.
	 */
	public Date getUpdateDate( ) {
		return this.updateDate;
	}

	public String toString( ) {
		String str = "VXUser={";
		str += super.toString();
		str += "name={" + name + "} ";
		str += "firstName={" + firstName + "} ";
		str += "lastName={" + lastName + "} ";
		str += "emailAddress={" + emailAddress + "} ";
		str += "description={" + description + "} ";
		str += "credStoreId={" + credStoreId + "} ";
		str += "isVisible={" + isVisible + "} ";
		str += "groupIdList={" + groupIdList + "} ";
		str += "groupNameList={" + groupNameList + "} ";
		str += "userRoleList={"+ userRoleList +"}"
;		str += "}";
		return str;
	}
}
