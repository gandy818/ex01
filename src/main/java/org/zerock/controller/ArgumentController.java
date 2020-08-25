package org.zerock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.Member;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/arg/*")
@Log4j
public class ArgumentController {

	
	// /arg/a?name=john
	@RequestMapping("/a")
	public void method1(HttpServletRequest req) {
		
		//먼저 req가 잘 들어있는지 확인
		log.info(req);
		log.info(req.getParameter("name"));
	}
	
	//param 더 간단하게 하는 방법
	@RequestMapping("/b")
	public void method2(@RequestParam("name") String name) {
		log.info(name);
	}
	
	//param name = arg name 이면(변수명이 같으면) 생략 가능
	@RequestMapping("/c")
	public void method3(@RequestParam String name) {
		log.info("c method");
		log.info(name);
	}
	
	//requestParam annotation도 생략 가능 
	@RequestMapping("/d")
	public void method(String name) {
		log.info("d method");
		log.info(name);
	}
	
	//2개이상
	
	// /e?name=jane&age=100 순서 상관 x  e?age=100&name=jane 이여도 가능
	@RequestMapping("/e")
	public void method5(HttpServletRequest req) {
		log.info("e method");
		log.info(req.getParameter("name"));
		log.info(req.getParameter("age"));
	}
	
	@RequestMapping("/f")
	public void method6(String name, String age) {
		log.info("f method");
		log.info(name);
		log.info(age);
	
		//원래 형변환
		int ageInt = Integer.valueOf(age);
	}
	
	//자동으로 형변환
	
	@RequestMapping("/g")
	public void method7(String name, int age) {
		log.info("g method");
		log.info(name);
		log.info(age);
	}
	 
	//member 객체도 만들고 name, age 값이 잘 들어감
	@RequestMapping("/h")
	public void method8(String name, int age) {
		log.info("h method");
		
		Member member = new Member();
		member.setName(name);
		member.setAge(age);
	
		log.info(member);
	
	}
	
	//member 객체를 만들지 않아도 가능
	@RequestMapping("/i")
	public void method9(Member member) {
		log.info("i method");
		log.info(member);
		
	}
}
