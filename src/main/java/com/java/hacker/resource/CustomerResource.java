
/**************************************************************************************************************
 * Module Name: hacker-rank-rest
 * Version Control Block
 * Date         Version    Author          Reviewer       Change Description
 * -----------  ---------  --------------  -------------  -------------------
 * Mar 28, 2020 1.0        Singh Bed       xxxxxxxxx      Created
 * -----------  ---------  --------------  -------------  -------------------
 **************************************************************************************************************/

package com.java.hacker.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;

import com.java.hacker.helper.CustomerHelper;
import com.java.hacker.model.Customer;
import com.java.hacker.model.Customers;

/**************************************************************************************************************
 * Java File: CustomerResource.java
 * Author  : Bed Singh
 * Description :  
 **************************************************************************************************************/

@Resource
@Path("/customers")
public class CustomerResource {

	private static final Logger logger = LogManager.getLogger(CustomerResource.class);

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Customers getAllCustomers() {
		MDC.put("custId", "ALL_CUST");
		Customers customers = new Customers();
		customers.setCustomers(new ArrayList<>(CustomerHelper.getCustomers().values()));

		logger.debug("Get all customers: {}", customers);
		return customers;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCustomer(Customer customer) throws URISyntaxException 
	{
		if(customer.getFirstName() == null || customer.getLastName() == null) {
			return Response.status(400).entity("Please provide all mandatory inputs").build();
		}
		customer.setCustId(CustomerHelper.getCustomers().values().size()+1);
		customer.setUri("/customer-mgmt/"+customer.getCustId());
		CustomerHelper.getCustomers().put(customer.getCustId(), customer);
		MDC.put("custId", String.valueOf(customer.getCustId()));
		logger.debug("Added customer: {}", customer);

		return Response.status(201).contentLocation(new URI(customer.getUri())).build();
	}


	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getCustomerById(@PathParam("id") int id) throws URISyntaxException 
	{
		Customer user = CustomerHelper.getCustomers().get(id);
		if(user == null) {
			return Response.status(404).build();
		}
		logger.info("Get Customer for CustomerId: {}", id);
		return Response
				.status(200)
				.entity(user)
				.contentLocation(new URI("/customer-mgmt/"+id))
				.build();
	}


	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(@PathParam("id") int id, Customer customer) throws URISyntaxException 
	{
		Customer temp = CustomerHelper.getCustomers().get(id);
		if(customer == null) {
			return Response.status(404).build();
		}
		temp.setFirstName(customer.getFirstName());
		temp.setLastName(customer.getLastName());
		CustomerHelper.getCustomers().put(temp.getCustId(), temp);

		logger.debug("Updated customer: {}", customer);
		
		return Response.status(200).entity(temp).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") int id) throws URISyntaxException {
		Customer customer =  CustomerHelper.getCustomers().get(id);
		if(customer != null) {
			CustomerHelper.getCustomers().remove(customer.getCustId());
			logger.info("Customer deleted, CustomerId: {}", id);
			return Response.status(200).build();
		}
		return Response.status(404).build();
	}    
}
