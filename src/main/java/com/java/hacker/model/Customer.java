
/**************************************************************************************************************
 * Module Name: hacker-rank-rest
 * Version Control Block
 * Date         Version    Author          Reviewer       Change Description
 * -----------  ---------  --------------  -------------  -------------------
 * Mar 28, 2020 1.0        Singh Bed       xxxxxxxxx      Created
 * -----------  ---------  --------------  -------------  -------------------
 **************************************************************************************************************/

package com.java.hacker.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;
import lombok.Setter;

/**************************************************************************************************************
 * Java File: Customer.java
 * Author  : Bed Singh
 * Description :  
 **************************************************************************************************************/

@Getter
@Setter
@XmlRootElement(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer custId;
	private String firstName;
	private String lastName;
	private String uri;
	
	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		 return new ToStringBuilder(this).
			       append("CustId", custId).
			       append("FirstName", firstName).
			       append("LastName", lastName).
			       append("URI", uri).
			       toString();
	}
}
