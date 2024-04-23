package com.hostel.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hostel.hms.model.Feedback;
import com.hostel.hms.service.FeedbackService;

import jakarta.validation.Valid;

@Validated
@Controller
public class FeedbackController {

	@Autowired
	private FeedbackService feedser;


	@PostMapping("/feedbacks")
	public String saveFeedback(@Valid @ModelAttribute("feedback") Feedback feedback, BindingResult result) {
		return feedser.savefeedback(feedback, result);
	}

	@GetMapping("/feedbacks")
	public String listFeedbacks(Model model) {
		model.addAttribute("feedbacks", feedser.findallfeed());
		return "feedback";
	}

	@GetMapping("/feedback/new")
	public String showCreateForm(Model model) {
		Feedback feedback = new Feedback();
		model.addAttribute("feedback", feedback);
		return "create_feedback"; // Adjust the view name as needed
	}
}
