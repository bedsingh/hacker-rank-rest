
/**************************************************************************************************************
 * Module Name: hacker-rank-rest
 * Version Control Block
 * Date         Version    Author          Reviewer       Change Description
 * -----------  ---------  --------------  -------------  -------------------
 * Mar 28, 2020 1.0        Singh Bed       xxxxxxxxx      Created
 * -----------  ---------  --------------  -------------  -------------------
 **************************************************************************************************************/

package com.java.hacker.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.java.hacker.resource.CustomerResource;

/**************************************************************************************************************
 * Java File: JerseyConfig.java
 * Author  : Bed Singh
 * Description :  
 **************************************************************************************************************/

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		 
		register(CustomerResource.class);
	}
}
