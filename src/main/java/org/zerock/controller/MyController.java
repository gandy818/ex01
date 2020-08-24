package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;


//component라고 안쓰고 Controller라고 써도 빈 생성 (controller가 component를 포함하고있기 때문)
//요청을 전달 받을 수 있다.

@Controller

//my 경로로 오면 일을 하는 어노테이션
//@RequestMapping("/my/*")
@Log4j
public class MyController {
	
	@RequestMapping("")
	public void myHandler1() {
		log.info("my controller is working.....");
	}
	
	@RequestMapping("/a")
	public void myHandler2() {
		log.info("my controller2 is working.....");
	}
	@RequestMapping("/b")
	public void myHandler3() {
		log.info("my controller3 is working.....");
	}
	
	//get방식
	@RequestMapping(value = "/c", method = RequestMethod.GET)
	public void myHandler4() {
		log.info("myHandler4................");
	}
	
	//post방식
	@RequestMapping(value = "/c", method = RequestMethod.POST)
	public void myHandler5() {
		log.info("myHandler5................");
	}
	
	
	@GetMapping("/d")
	public void myHandler6() {
		log.info("myHandler6..........................");
	}
	
	@PostMapping("/d")
	public void myHandler7() {
		log.info("myHandler7..........................");
	}
	
}
