package com.hostel.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hostel.hms.model.Room;
import com.hostel.hms.model.Student;
import com.hostel.hms.repo.RoomRepo;
import com.hostel.hms.repo.StudentRepo;
import com.hostel.hms.service.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentController {
	@Autowired
	private StudentRepo stdrepo;
	@Autowired
	private RoomRepo roomrepo;

	@Autowired
	private StudentService stdser;

	@PostMapping("/students")
	public String saveMember(@Valid Student student, Model model) {
		stdser.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students")
	public String listMembers(@Valid Model model) {
		model.addAttribute("students", stdser.getAllstd());
		return "students";

	}

	@GetMapping("/student/delete/{stuid}")
	public String deleteStudent(@PathVariable("stuid") int id) {
		stdser.deletestudent(id);
		return "redirect:/students";
	}

	@GetMapping("/student/new")
	public String showCreateForm(Model model) {
		List<Room> availableRooms = stdser.getroom();
		model.addAttribute("rooms", availableRooms);
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	@GetMapping("/student/{stuid}")
	public String showUpdateForm(@Valid @PathVariable("stuid") int id, Model model) {
		model.addAttribute("student", stdser.getStdById(id));
		return "update_student";

	}

	@PostMapping("/student/update")
	public String updateStudent(@Valid Student student) {
		stdrepo.save(student);
		return "redirect:/students";

	}

	@GetMapping("/students/room/{roomno}")
	public String getStudentsByRoomNo(@PathVariable("roomno") int roomno, Model model) {
		model.addAttribute("students",stdser.getStdByRoomNo(roomno));
		return "stdbyroom";
	}

}
