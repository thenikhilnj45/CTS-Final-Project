package com.hostel.hms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hostel.hms.model.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, String>  {

}
