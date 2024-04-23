package com.hostel.hms.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostel.hms.model.Room;
import com.hostel.hms.repo.RoomRepo;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepo roomrepo;
	

	public Room getByRoomno(int roomno) {
	return roomrepo.findById(roomno).get();
}
	public List<Room> getAllBook(){
	return roomrepo.findAll();
}
	public void saveroom(Room r) {
	roomrepo.save(r);
	}
	public void deleteByRoomno(int id) {
		roomrepo.deleteById(id);
	}
	
}
