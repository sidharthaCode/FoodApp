package com.sid.foodapp.helper;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebIntilizer  extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ConfigurationClass.class};
		
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

}
