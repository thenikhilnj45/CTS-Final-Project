package com.hostel.hms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hostel.hms.model.Room;


public interface RoomRepo  extends JpaRepository<Room, Integer> {

	Room findByRoomno(int roomno);

}
