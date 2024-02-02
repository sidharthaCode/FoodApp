package com.sid.foodapp.helper;

import javax.persistence.EntityListeners;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.sid")

public class ConfigurationClass 
{
	@Bean
	public InternalResourceViewResolver resolver()
	{
		InternalResourceViewResolver res=new InternalResourceViewResolver();
		
		res.setSuffix(".jsp");
		res.setPrefix("/");
		return res;
		
	}
	
	@Bean
	public EntityManagerFactory getEmf()
	{
		return Persistence.createEntityManagerFactory("sidhartha");
	}

}
