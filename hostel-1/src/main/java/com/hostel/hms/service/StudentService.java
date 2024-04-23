package com.hostel.hms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hostel.hms.model.Room;
import com.hostel.hms.model.Student;
import com.hostel.hms.repo.RoomRepo;
import com.hostel.hms.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private RoomRepo roomrepo;

	@Autowired
	private StudentRepo stdrepo;

	Model model;

	public List<Room> getroom() {
		List<Room> availableRooms = roomrepo.findAll().stream().filter(room -> room.getCapacity() > 0)
				.collect(Collectors.toList());
		return availableRooms;
	}

	public Room rtroom(int id) {
		Student student = stdrepo.findById(id).orElseThrow();
		Room room = roomrepo.findById(student.getRoomno()).orElseThrow();
		stdrepo.deleteById(id);
		room.setCapacity(room.getCapacity() + 1);
		room.setAvailability(true);

		return room;
	}

	public void saveStudent(Student student) {
		Room room = roomrepo.findById(student.getRoomno()).orElseThrow();
		int capacity = room.getCapacity();
		if (capacity > 0) {
			// Email.mail(student);
			stdrepo.save(student);
			room.setCapacity(capacity - 1);
			roomrepo.save(room);
		} else if (room.getCapacity() <= 0) {
			room.setAvailability(false);
			roomrepo.save(room);
		}
	}

	public void deletestudent(int id) {
		Student student = stdrepo.findById(id).orElseThrow();
		Room room = roomrepo.findById(student.getRoomno()).orElseThrow();
		stdrepo.deleteById(id);
		room.setCapacity(room.getCapacity() + 1);
		if (!room.isAvailability()) {
			room.setAvailability(true);
		}
		roomrepo.save(room);

	}

	public Student getStdById(int id) {
		return stdrepo.findById(id).get();
	}

	public List<Student> getAllstd() {
		return stdrepo.findAll();
	}

	public List<Student> getStdByRoomNo(int id) {
		return stdrepo.findByRoomno(id);
	}

}

//

//
//@Autowired
//private BookRepository bRepo;
//
//public void save(Book b) {
//	bRepo.save(b);
//}
//
//public List<Book> getAllBook(){
//	return bRepo.findAll();
//}
//
//public Book getBookById(int id) {
//	return bRepo.findById(id).get();
//}
//public void deleteById(int id) {
//	bRepo.deleteById(id);
//}
//public Student getStdById(int id) {
//	return stdrepo.findById(id).get();
//}
//
//public List<Student> getAllstd() {
//	return stdrepo.findAll();
//}
