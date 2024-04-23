package com.hostel.hms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hostel.hms.model.User;
import com.hostel.hms.service.UserService;

import jakarta.validation.Valid;

// ...

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/signup")
	public String signupForm(@Valid Model model) {
		System.out.println("inside signup");
		model.addAttribute("user", new User());
		return "auth/user";
	}

	@GetMapping("/login")
	public String LoginForm(@Valid Model model) {
		System.out.println("inside login");
		model.addAttribute("user", new User());
		return "auth/login";
	}

	@GetMapping("/reset")
	public String ResetForm(@Valid Model model) {
		System.out.println("inside reset");
		model.addAttribute("user", new User());
		return "auth/reset";
	}

	@PostMapping("/signup")
	public String signupSubmit(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
		System.out.println("inside  post signup");

		String res = "";
		System.out.println(bindingResult);
		if (bindingResult.hasErrors()) {
			res = "auth/user";
		} else if (user.getPassword().equals(user.getConfirmpassword())) {
			userService.signup(user);
			res = "redirect:/stdmain";
		} else {
			model.addAttribute("error", "Password and Confirm password should be Same");
			res = "user";
		}
		return res;
	}

	@PostMapping("/login")
	public String loginSubmit(@Valid @ModelAttribute User user, BindingResult bindingResult) {
		System.out.println("Inside post login");
		boolean success = userService.login(user);
		String res = "";
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			res = "auth/login";
		}
		else if (success) {
			res = "redirect:/stdmain";
		} else {
			res = "redirect:/login";
		}
		return res;
	}

	@PostMapping("/reset")
	public String resetSubmit(@Valid @ModelAttribute User user, BindingResult bindingResult) {
		System.out.println("inside post reset");
		boolean success = userService.resetPassword(user);
		String res="";
		if (bindingResult.hasErrors()) {
			res="auth/reset";
		}
		else if (success) {
			res="redirect:/login";
		} else {
			res="redirect:/reset";
		}
		return res;
	}
}
