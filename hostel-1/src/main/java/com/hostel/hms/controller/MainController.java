package com.hostel.hms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home() {
		System.out.println("Inside Main ");
		return "main/main";
	}
	
	@GetMapping("/stdmain")
	public String stdmain() {
		System.out.println("Inside student  Main ");
		return "Main/stdmain";
	}
	@GetMapping("/roommain")
	public String roommain() {
		System.out.println("Inside Room  Main ");
		return "Main/roomMain";
	}
	@GetMapping("/feedmain")
	public String feedmain() {
		System.out.println("Inside Feed Main ");
		return "Main/feedMain";
	}
	@GetMapping("/logout")
	public String main() {
		System.out.println("Inside Main ");
		return "redirect:/login";
	}
}
