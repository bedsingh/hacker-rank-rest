
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
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;
import lombok.Setter;

/**************************************************************************************************************
 * Java File: Customers.java
 * Author  : Bed Singh
 * Description :  
 **************************************************************************************************************/


@Getter
@Setter
@XmlRootElement(name = "customers")
public class Customers implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Customer> customers;

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
