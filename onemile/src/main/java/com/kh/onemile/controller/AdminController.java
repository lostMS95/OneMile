package com.kh.onemile.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
public class AdminController {
	
	@GetMapping("/approve")
	public String approve() {
		return "approve";
	}
	@PostMapping("/approve")
	public String approve(Model model) {
		return "";
	}
}
