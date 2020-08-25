package org.zerock.controller;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.CustomMemberEditor;
import org.zerock.domain.Member;
import org.zerock.domain.MemberList;

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
	public void method4(String name) {
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
	
	// 똑같은 파라미터가 올 경우 -배열
	//k?name=john&name=jane&name=donald
	@RequestMapping("/j")
	public void method10(@RequestParam String[] name) {
		log.info("j method");
		log.info(name.length);
		for(String n : name) {
			log.info(n);
		}
	}
	
	//똑같은 파라미터가 올 경우 2 -리스트
	//k?n=john&n=jane&n=donald
	@RequestMapping("/k")
	public void method11(@RequestParam("n") List<String> name) {
		log.info("k method");
		log.info(name.size());
		for(String n : name) {
			log.info(n);
		}
	}
	//[ = %5B      ] = %5D
	//l?list%5B0%5D.name=jane&list%5B1%5D.name=john
	@RequestMapping("/l")
	public void method12(MemberList member) {
		log.info("l method");
		log.info(member);
	}
	
	@RequestMapping("/m")
	public void method13(@RequestParam("date") Date date) {
		log.info("m method");
		log.info(date);
	}
	
	
	@RequestMapping("n")
	public void method14(@RequestParam("mem") Member member) {
		log.info("n method");
		log.info(member);
	}
	
	
	//initbinder 어노가 붙은 return 타입의 메서드가 있으면 이거 먼저 실행 
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
		binder.registerCustomEditor(Member.class, new CustomMemberEditor());
	}
	
	
	
	//model 
	
	@RequestMapping("/o")
	public void method15(Model model) {
		log.info("o method");
		log.info(model);
		
		model.addAttribute("my-attr","my-value");
		
		log.info(model);
	}
	
	@RequestMapping("/p")
	public void method16(@ModelAttribute("str") String str, Model model) {
		log.info("p method");
		log.info(model);
	
//		model.addAttribute(("attr", service.get(str));
//		model.addAttribute("str",str);
	
		log.info(model);
	
	}
	
	@RequestMapping("/q")
	public void  method17(Model model) {
		log.info("q method");
		
		//정석
		model.addAttribute("str", "str-value");
		
		//이름을 정해주지 않으면 이름은 소문자type명. 여기서는 string
		model.addAttribute("str-value2");
		
//		Member member = new Member();
//		member.setName("sss");
//		member.setAge(22);
		
		model.addAttribute(new Member());
	
		
		//stringList
		model.addAttribute(new String[] {"a", "b"});
		
		//memberList
		List<Member> mlist = new ArrayList<Member>();
		
		mlist.add(new Member());
		model.addAttribute(mlist);
		
		//비어있는 리스트는 등록x
//		model.addAttribute(new ArrayList<Member>());
		
		log.info(model);
	}
	
	
	//기본타입이 아닌 경우
	//항상 @ModelAttribute가 생략 되있음 
	@RequestMapping("/r")
	public void method18(@ModelAttribute Member member, Model model) {
		log.info("r method");
		log.info(model);
	}
	
}
