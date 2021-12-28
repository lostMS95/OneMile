package com.kh.onemile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.onemile.service.miles.MilesService;
import com.kh.onemile.vo.MilesVO;

@RequestMapping("/miles")
@Controller
public class MilesController {
	
	@Autowired
	private MilesService milesService;
	//마일즈 생성
	@GetMapping("/create")
	public String create() {
		return "miles/create";
	}
	@PostMapping("/create")
	public String create(@ModelAttribute MilesVO milesVo) {
		milesService.create(milesVo);
		return "redirect:/";
	}
}