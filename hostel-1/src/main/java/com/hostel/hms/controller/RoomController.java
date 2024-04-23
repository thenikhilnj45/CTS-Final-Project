package com.hostel.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hostel.hms.model.Room;
import com.hostel.hms.repo.RoomRepo;
import com.hostel.hms.service.RoomService;

import jakarta.validation.Valid;

@Controller
public class RoomController {
	
	@Autowired
	private RoomService roomser;
	
	@GetMapping("/rooms")
	public String listRooms(Model model) {
		List<Room> r=roomser.getAllBook();
		model.addAttribute("rooms", r);
		return "rooms";

	}
	@GetMapping("/room/delete/{roomno}")
	public String deleteStudent(@PathVariable("roomno") int id) {
	    roomser.deleteByRoomno(id);
	    return "redirect:/rooms";
	}
	@GetMapping("/room/new")
	public String showCreateForm(Model model) {
		Room room = new Room();
		model.addAttribute("room", room);
		return "create_room";

}
	@PostMapping("/rooms")
	public String showCreateForm(@Valid Room room) {
		roomser.saveroom(room);
		return "redirect:/rooms";
	}

	
	
	@GetMapping("/room/{roomno}")
	public String showUpdateForm(@PathVariable("roomno") int id, Model model) {
		Room room =roomser.getByRoomno(id);
		model.addAttribute("room", room);
		return "update_room";

	}

	@PostMapping("/room/update")
	public String updateRoom(Room room) {
		roomser.saveroom(room);
		return "redirect:/rooms";

	}
	
}
