package com.example.day5.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.day5.model.model;
import com.example.day5.service.service;

@RestController
public class controller {
	
	@Autowired
	public service ser;
	
	@PostMapping("/bookingsystem")
	
	public model savebookingsystem(@RequestBody model m)
	{
		return ser.savebookingModel(m);
	}
	@GetMapping
	
	public List<model> savebookingsystem()
	{
		return ser.getDetails();
	}
	
     //delete
	@DeleteMapping("/delete/{cusid}")
	public String deletestud(@PathVariable("cusid")int cusid)
	{
		ser.delete(cusid);
		return "Customer with ID "+cusid+" is deleted";
	}
	
	//delete if present else not
	@DeleteMapping("/deletebyuserid/{cusid}")
	public ResponseEntity<String>customerinfo(@PathVariable int cusid)
	{
		boolean deleted=ser.customerinfo(cusid);
		if(deleted)
		{
			return ResponseEntity.ok("customer with ID"+cusid+"deleted");
		}
		else 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("customer with ID "+cusid+" not found");
		}
	}
	
	//update
	@PutMapping("/customerup")
	public model customerup(@RequestBody model m)
	{
		return ser.customerup(m);
	}

	//delete by parameter
	@DeleteMapping("/reqparam")
	public String removeByreq(@RequestParam("cusid")int cusid)
	{
		ser.delete(cusid);
		return "Customer with ID "+cusid+" is deleted"	;
    }
	
	
	@GetMapping("/customer/{cusid}")
	public ResponseEntity<?>getUserId(@PathVariable int cusid)
	{
		Optional<model>customer=ser.getUserId(cusid);
		if(customer!=null)
		{
			return ResponseEntity.ok(customer);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USer  not avavilable");
	}
	
	@PutMapping("/customerinfo/{cusid}")
	public ResponseEntity<String> updateStudDetails(@PathVariable int cusid)
	{
		boolean updated = ser.updateStudInfo(cusid);
		if(updated)
		{
			return ResponseEntity.ok("Student with Id "+cusid+" updated successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with Id "+cusid+" not found");
		}
	}
}