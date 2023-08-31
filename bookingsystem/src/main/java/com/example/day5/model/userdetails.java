package com.example.day5.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class userdetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int user_id;
	public String name;
	public String phonenum;
	public int age;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bus_id", referencedColumnName = "busid")
	public busmodel busdetails;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public busmodel getBusdetails() {
		return busdetails;
	}
	public void setBusdetails(busmodel busdetails) {
		this.busdetails = busdetails;
	}
}