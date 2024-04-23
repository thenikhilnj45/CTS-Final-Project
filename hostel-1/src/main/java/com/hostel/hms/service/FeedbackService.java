package com.hostel.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.hostel.hms.model.Feedback;
import com.hostel.hms.repo.FeedbackRepo;

import jakarta.validation.Valid;
@Service
public class FeedbackService {
	
	 @Autowired
	    private FeedbackRepo feedrepo;
	 
	public String savefeedback(@Valid @ModelAttribute("feedback") Feedback feedback, BindingResult result) {
		String res="";
		if (result.hasErrors()) {
	            res="create_feedback"; // Adjust the vi
	        }
	        feedrepo.save(feedback);
	        res="redirect:/feedbacks";
	        return res;
	}
	
	public List<Feedback> findallfeed() {
		
		return feedrepo.findAll();
		
	}
	
	
	
	
}
