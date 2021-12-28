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
public class CommuController {

	@Autowired
	private CommuService commuService;
	
	@GetMapping("/questions/write")
	public String writeQ() {
		return "commu/questions/write";
	}
	
	@PostMapping("/questions/write")
	public String writeQ(@ModelAttribute CommuVO commuVo) throws IllegalStateException, IOException {
		commuService.write(commuVo);
		return "redirect:questions/list";
	}
	
	@GetMapping("/questions/list")
	public String listQ() {
		return "commu/questions/list";
	}
	
	@RequestMapping("/questions/detail")
	public String detailQ(CommuVO commuVo, Model model) throws IOException {
		
		model.addAttribute("read", commuService.detail(commuVo.getCommuNo()));
		
		return "commu/questions/detail";
	}
	
	@GetMapping("/boonsil/write")
	public String writeBoonsil() {
		return "commu/boonsil/write";
	}
	
	@PostMapping("/boonsil/write")
	public String writeBoonsil(@ModelAttribute CommuVO commuVo) throws IllegalStateException, IOException {
		commuService.write(commuVo);
		return "redirect:boonsil/list";
	}
	
	@GetMapping("/boonsil/list")
	public String listBoonsil() {
		return "commu/boonsil/list";
	}
	
	@RequestMapping("/boonsil/detail")
	public String detailBoonsil(CommuVO commuVo, Model model) throws IOException {
		
		model.addAttribute("read", commuService.detail(commuVo.getCommuNo()));
		
		return "commu/boonsil/detail";
	}
	
	@GetMapping("/funding/write")
	public String writeFunding() {
		return "commu/funding/write";
	}
	
	@PostMapping("/funding/write")
	public String writeFunding(@ModelAttribute CommuVO commuVo) throws IllegalStateException, IOException {
		commuService.write(commuVo);
		return "redirect:funding/list";
	}
	
	@GetMapping("/funding/list")
	public String listFunding() {
		return "commu/funding/list";
	}
	
	@RequestMapping("/funding/detail")
	public String detailFunding(CommuVO commuVo, Model model) throws IOException {
		
		model.addAttribute("read", commuService.detail(commuVo.getCommuNo()));
		
		return "commu/funding/detail";
	}
}
