package com.hostel.hms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public   class Room {

	
	
	@Id
	@Column
	@NotNull(message="Room number  required")
	private int roomno;
	
	
	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	@Column
	@NotNull(message="Room type must be   required")
	private String roomtype;
	
	@Column
	@NotNull(message="Room capacity is required")
	private int capacity;
	
	@Column
	@NotNull(message="Availability must required")
	private boolean availability;
	
	@Column
	private int fees;

	
}
