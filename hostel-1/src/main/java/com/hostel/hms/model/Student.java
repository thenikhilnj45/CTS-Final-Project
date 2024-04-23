package com.hostel.hms.model;

import java.sql.Date;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
@Entity
public  class Student {
	//use validating api 
	@Id
	@Column()
	@NotNull(message="Stduent ID must")
	private int stuid;
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public long getGmobile() {
		return gmobile;
	}
	public void setGmobile(long gmobile) {
		this.gmobile = gmobile;
	}
	public String getGaddress() {
		return gaddress;
	}
	public void setGaddress(String gaddress) {
		this.gaddress = gaddress;
	}
	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	@NotNull(message ="Name Required")
	private String name;
	@NotNull(message ="Age Required")
	@Range(min = 18,max =100)
	private int age;
	@Column
	private String gender;
	@NotNull(message ="Date Must Be in  format of DD/MM/YYYY")
	@Column
	private Date dob;
	@NotNull(message ="Address  Required")
	@Column
	private String address;
	@NotNull(message ="Mobile Number is  Required")
	@Range(min=12,message="Mobile Number must be 10 digits")
	@Column
	private long mobile;
	@NotNull(message ="Email must be  Required")
	@Email(message="Email must be in format of abc@gmail.com")
	@Column
	private String email;
	@NotNull(message ="Aadhar must  Required")
	@Range(min=12)
	@Column
	private long aadhar;
	@NotNull(message ="Name Required")
	@Column
	private String gname;
	@NotNull(message ="Name Required")
	@Column
	private long gmobile;
	@NotNull(message ="Address Required")
	@Column
	private String gaddress;
	@NotNull(message ="Room number  Required")
	@Column
	private int roomno;
	@NotNull(message ="Date Need to be choosen")
	@Column
	private Date doj;
}
