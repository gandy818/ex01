package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.Member;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ret")
@Log4j
public class ReturnController {

	@RequestMapping("/a")
	public void methoda() {
		log.info("a method");
	}
	
	@RequestMapping("/b")
	public String methodb() {
		log.info("b method");
		
		return "/ret/a"; //포워드 해준 것이니 주소는 그대로 /ret/b가 남아있음
	}
	
	@RequestMapping("/c")
	@ResponseBody
	public String methodc() {
		log.info("c method");

		//메소드에 @ResponseBody라는 어노가 없으면 hello world.jsp를 찾음
		return "hello world";	
	}
	
	
	//model의 값을 꺼내기
	@RequestMapping("/d")
	public String methodd(Model model) {
		log.info("d method");
		
		//myAttr안에 my-val이라는 값을 넣음 읽을때는 a.jsp에서 ${myAttr}로 읽음
		model.addAttribute("myAttr", "my-val");
		
		return "/ret/a";
	}
	
	@RequestMapping("/e")
	public String methode(Model model) {
		log.info("e method");
		
		Member member = new Member();
		member.setName("ddd");
		member.setAge(22);
		
		model.addAttribute("mem", member);
		
		return "/ret/a";
	}
	
	@RequestMapping("/f")
	public String methodf(Model model) {
		log.info("f method");
		Member member = new Member();
		member.setName("seoul");
		member.setAge(1000);
		
		model.addAttribute(member);
		
		return "/ret/a";
	}
	
	
	@RequestMapping("/g")
	public String methodg(Model model) {
		log.info("g method");
		
		
		String[] strs = new String[]{"seoul", "jeju", "korea"};
		model.addAttribute("cities", strs);
		
		return "/ret/b";
	}
	
	//★
	@RequestMapping("/h")
	public String methodh(Model model) {
		log.info("h method");
		
		//객체 생성
		Member m1 = new Member();
		m1.setName("seoul");
		m1.setAge(33);
		
		Member m2 = new Member();
		m2.setName("korea");
		m2.setAge(46);
		
		//배열을 이용한 방법
		Member[] members = new Member[] {m1,m2};
//		model.addAttribute("memberList", members); 결과 같음 (이름을 설정 안해주면 자동으로 이름이 만들어져서)
		model.addAttribute(members);
		
		
		//List를 이용한 방법
		List<Member> members2 = new ArrayList<>();
		members2.add(m1);
		members2.add(m2);
//		model.addAttribute("memberList", members2); 결과 같음
		model.addAttribute(members2);
		
		return "/ret/b";
	}
	
	
	//i?name=jeju
	@RequestMapping("/i")
	public String methodi(@ModelAttribute("name") String name) {
		log.info("i method");
		log.info(name);
		
//		model.addAttribute("name", name); 원래는 이렇게 해줬으나 @ModelAttribute 어노를 사용하면 안해줘도 됨
		
		return "/ret/c";
	}
	
	//기본타입이나 스트링이 아닐 경우
	// /j?name=jeju&age=33
	@RequestMapping("/j")
	public String methodj(Member member) {
		log.info("j method");
		
		
		
		return "/ret/c";
	}
	
	
	@RequestMapping("/k")
	public String methodk(@ModelAttribute("mem") Member member) {
		log.info("k method");
		
		
		
		return "/ret/c";
	}
	
	
	
	
	
 }
