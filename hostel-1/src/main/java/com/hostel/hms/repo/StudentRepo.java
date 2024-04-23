package com.hostel.hms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hostel.hms.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	Student findByStuid(int stuid);
	List<Student> findByRoomno(int roomno);}

	