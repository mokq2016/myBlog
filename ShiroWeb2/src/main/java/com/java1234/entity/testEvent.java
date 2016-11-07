package com.java1234.entity;

import org.springframework.context.ApplicationEvent;

public class testEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9183337181447800171L;

	public testEvent(Object source) {
		super(source);
	}

}
