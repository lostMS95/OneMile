package com.kh.onemile.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.onemile.service.commu.CommuService;
import com.kh.onemile.vo.CommuVO;

@RequestMapping("/commu/questions")
@Controller
public class QuestionsController {

	@Autowired
	private CommuService commuService;
	
	@GetMapping("/write")
	public String write() {
		return "commu/questions/write";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute CommuVO commuVo) throws IllegalStateException, IOException {
		commuService.write(commuVo);
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String list() {
		return "comm/questions/list";
	}
}
