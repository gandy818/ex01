package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class MemberList {

	//member를 여러개 가질수 있는 필드
	private List<Member> list;
	
	public MemberList() {
	list = new ArrayList<>();
	}
	
 }
