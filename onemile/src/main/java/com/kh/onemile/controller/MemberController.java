package com.kh.onemile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.onemile.dto.member.MemberDTO;
import com.kh.onemile.service.member.MemberService;


@RequestMapping("/member")
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService; 
	
	@GetMapping("/join")
	public String getJoin() {
		return "join";
	}
	@PostMapping("/join")
	public void postJoin(@ModelAttribute MemberDTO memberDTO) {
		memberService.join(memberDTO);
	}
}
