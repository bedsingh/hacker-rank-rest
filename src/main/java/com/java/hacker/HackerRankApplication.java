package com.java.hacker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HackerRankApplication extends SpringBootServletInitializer  {

    private static final Logger logger = LogManager.getLogger(HackerRankApplication.class);
    private static final String LINE1 = "*****************************************************"; 
    
	public static void main(String[] args) {
		logger.info(LINE1);
		logger.info("************ Hacker Application Starting ************");
		logger.info(LINE1);
		
		SpringApplication.run(HackerRankApplication.class, args);
		
		logger.info(LINE1);
		logger.info("************ Hacker Application Started. ************");
		logger.info(LINE1);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return super.configure(builder);
	}
}
