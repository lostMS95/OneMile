package com.kh.onemile.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/social")
@RestController
public class SocialController {
	
	@GetMapping("/reg")
	public String reg() {
		return "reg";
	}
	@PostMapping("/reg")
	public String reg(Model model) {
		return "detail";
	}
}
