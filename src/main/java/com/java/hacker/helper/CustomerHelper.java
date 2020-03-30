
/**************************************************************************************************************
 * Module Name: hacker-rank-rest
 * Version Control Block
 * Date         Version    Author          Reviewer       Change Description
 * -----------  ---------  --------------  -------------  -------------------
 * Mar 28, 2020 1.0        Singh Bed       xxxxxxxxx      Created
 * -----------  ---------  --------------  -------------  -------------------
 **************************************************************************************************************/

package com.java.hacker.helper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.java.hacker.model.Customer;

/**************************************************************************************************************
 * Java File: CustomerHelper.java
 * Author   : Bed Singh
 * Description :  
 **************************************************************************************************************/

public class CustomerHelper {

	private static Map<Integer, Customer> customers = new ConcurrentHashMap<>();
	
	public static Map<Integer, Customer> getCustomers() {

		if(!customers.isEmpty()) {
			return customers;
		}

		Customer cust1 = new Customer();
		cust1.setCustId(1);
		cust1.setFirstName("Ved");
		cust1.setLastName("Singh");
		cust1.setUri("/customer-mgmt/1");

		Customer cust2 = new Customer();
		cust2.setCustId(2);
		cust2.setFirstName("Harry");
		cust2.setLastName("Potter");
		cust2.setUri("/customer-mgmt/2");

		customers.put(cust1.getCustId(), cust1);
		customers.put(cust2.getCustId(), cust2);

		return customers;
	}
}
