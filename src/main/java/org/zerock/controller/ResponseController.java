package org.zerock.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.Member;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/res")
@Log4j
public class ResponseController {

	@RequestMapping("/a")
	public String methoda() {
		log.info("a method");
		
		
		
		return "/res/a";
	}
	
	@RequestMapping("/b")
	@ResponseBody
	public String methodb() {
		log.info("b method");
		
		return "hello b method";
	}
	
	@RequestMapping("/c")
	@ResponseBody
	public String methodc() {
		log.info("c method");
		
		return "<li>john, 22 </li> <li>jane, 33</li>";
	}
	
	
	//JSON
	@RequestMapping("/d")
	@ResponseBody
	public String methodd() {
		log.info("d method");
		
		return "{\"name\":\"hohn\", \"age\":22}";
				
	}
	
	@RequestMapping("/e")
	public ResponseEntity<String> methode() {
		log.info("e method");
		String body = "{\"name\":\"hohn\", \"age\":22}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8 ");
		
		
		ResponseEntity<String> response = new ResponseEntity<>(body, header, HttpStatus.OK);
		
		return response;
	}
	
	@RequestMapping("/f")
	public ResponseEntity<String> methodf() {
		log.info("f method");
		Member member = null; //service.get(3);
		
		String body = "{\"name\":\""
				+member.getName()
				+", \"age\":"
				+member.getAge()
				+"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8 ");
		
		
		ResponseEntity<String> response = new ResponseEntity<>(body, header, HttpStatus.OK);
		
		return response;
	}
	
	@RequestMapping("/g")
	@ResponseBody
	public Member methodg() {
		log.info("g method");
		Member member = new Member();
		member.setName("donald");
		member.setAge(99);
		
		
		return member;
	}
	
	@RequestMapping("/h")
	@ResponseBody
	public List<Member> methodh() {
		
		List<Member> members = new ArrayList<>();
		
		//json의 배열 []
		//ex : [{"name" : "donald", "age":22}, {"name" : "jane", "age" : 2}]
		
		
		Member m1 = new Member();
		m1.setName("donald");
		m1.setAge(22);
		
		Member m2 = new Member();
		m2.setName("jane");
		m2.setAge(2);
		
		members.add(m1);
		members.add(m2);
		
		return members;
	}
	
	
	@RequestMapping("/i")
	public void methodi(HttpServletRequest req) {
		log.info("i method");
		
		//?뒤에 붙은 놈을 읽어봄
		log.info(req.getQueryString());
		
		log.info(req.getParameter("name"));
	}
	
	
	//HttpServletRequest 생략 가능
	@RequestMapping("j")
	public void methodj(String name, int age) {
		log.info("j method");
		log.info(name);
		log.info(age);
		
	}
	
	@RequestMapping("k")
	public void methodk(HttpServletRequest req) {
		log.info("k method");
		log.info(req.getQueryString());
		
		
	}
	
	@RequestMapping("l")
	@ResponseBody
	public Member methodl(int id) {
		log.info("l method");
	//	Member mem = service.get(id);
		Member mem = new Member();
		mem.setName("korea");
		mem.setAge(11);
		
		
		return mem;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
