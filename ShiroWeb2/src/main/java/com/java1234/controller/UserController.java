package com.java1234.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java1234.entity.User;


@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/login")
	public String login(String userName,String password,HttpServletRequest request){
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
			
		try {
			subject.login(token);
			Session session = subject.getSession();
			System.out.println("sessionId:" + session.getId());
			System.out.println("sessionHost:" + session.getHost());
			System.out.println("sessionTimeout:" + session.getTimeout());
			session.setAttribute("info", "session的数据");
			return "redirect:/success.html";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("user", new User());
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return "index";
		}
		
		
	}
	
}
