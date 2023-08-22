package com.day4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.day4.model.model;
import com.day4.service.service;

@RestController

public class controller {
	
	@Autowired
	public service ser;
	@PostMapping("/studentdet")
	
	public model savestudentdet(@RequestBody model m)
	{
		return ser.savedetailsModel(m);
	}
	@GetMapping
	public List<model> savestudentdet()
	{
		return ser.getDetails();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletestud(@PathVariable("id")int id)
	{
		ser.delete(id);
		return "student with ID"+id+"is delete";     
	}
	
	@PutMapping("/studput")
	public model updatestud(@RequestBody model m) 
	{
		return ser.updatestud(m);   
	}
}
