package com.kh.onemile.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.onemile.service.commu.CommuService;
import com.kh.onemile.vo.CommuVO;

@RequestMapping("/commu")
@Controller
public class CommuWithMapController {

	@Autowired
	private CommuService commuService;
	
	@GetMapping("/matjip/write")
	public String writeMatjip() {
		return "commu/matjip/write";
	}
	
	@PostMapping("/matjip/write")
	public String writeMatjip(@ModelAttribute CommuVO commuVo) throws IllegalStateException, IOException {
		commuService.write(commuVo);
		return "redirect:matjip/list";
	}
	
	@GetMapping("/matjip/list")
	public String listMatjip() {
		return "commu/matjip/list";
	}
	
	@RequestMapping("/matjip/detail")
	public String detailMatjip(CommuVO commuVo, Model model) throws IOException {
		
		model.addAttribute("read", commuService.detail(commuVo.getCommuNo()));
		
		return "commu/matjip/detail";
	}
	
	@GetMapping("/inc/write")
	public String writeInc() {
		return "commu/inc/write";
	}
	
	@PostMapping("/inc/write")
	public String writeInc(@ModelAttribute CommuVO commuVo) throws IllegalStateException, IOException {
		commuService.write(commuVo);
		return "redirect:inc/list";
	}
	
	@GetMapping("/inc/list")
	public String listInc() {
		return "commu/inc/list";
	}
	
	@RequestMapping("/inc/detail")
	public String detailInc(CommuVO commuVo, Model model) throws IOException {
		
		model.addAttribute("read", commuService.detail(commuVo.getCommuNo()));
		
		return "commu/inc/detail";
	}
	
	@GetMapping("/yam/write")
	public String writeYam() {
		return "commu/yam/write";
	}
	
	@PostMapping("/yam/write")
	public String writeYam(@ModelAttribute CommuVO commuVo) throws IllegalStateException, IOException {
		commuService.write(commuVo);
		return "redirect:yam/list";
	}
	
	@GetMapping("/yam/list")
	public String listYam() {
		return "commu/yam/list";
	}
	
	@RequestMapping("/yam/detail")
	public String detailYam(CommuVO commuVo, Model model) throws IOException {
		
		model.addAttribute("read", commuService.detail(commuVo.getCommuNo()));
		
		return "commu/yam/detail";
	}
}
