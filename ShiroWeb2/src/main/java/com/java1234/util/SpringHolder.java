package com.java1234.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class SpringHolder implements ApplicationContextAware {

	private static ApplicationContext context;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = applicationContext;
		
	}
	public static  ApplicationContext getApplicationContext(){
		return context;
	}

}
