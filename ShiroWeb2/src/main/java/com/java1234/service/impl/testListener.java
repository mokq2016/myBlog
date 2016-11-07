package com.java1234.service.impl;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.java1234.entity.testEvent;
@Component
public class testListener implements ApplicationListener<testEvent>{
	@Async  
	@Override
	public void onApplicationEvent(testEvent arg0) {
		System.out.println(arg0);
		System.out.println("接收到事件!!!!!!!!!!!!!!!@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		handleEvent();
		
	}
	private void handleEvent() {
		System.out.println("哈哈哈哈");
		
	}

}
