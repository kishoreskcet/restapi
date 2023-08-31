package com.example.day5.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.data.repository.cdi.Eager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.example.day5.model.model;
import com.example.day5.model.userdetails;
import com.example.day5.service.userservice;
//import com.example.day6.model.model;
//import com.example.day6.model.model;
//import com.example.day6.model.model;

@RestController
public class usercontroller {

	@Autowired
	public userservice ser;
	
	@PostMapping("/post")
	public userdetails details(@RequestBody userdetails user)
	{
		return ser.details(user);
	}
	
	@GetMapping("/get")
	public List<userdetails> savedetails()
	{
		return ser.getDetails();
	}
	@DeleteMapping("/delete/{user_id}")
	public String deletestud(@PathVariable("user-id")int user_id)
	{
		ser.delete(user_id);
		return "Customer with ID "+user_id+" is deleted";
	}
	@DeleteMapping("/deletebyuserid/{user_id}")
	public ResponseEntity<String>customerinfo(@PathVariable int user_id)
	{
		boolean deleted=ser.customerinfo(user_id);
		if(deleted)
		{
			return ResponseEntity.ok("customer with ID"+user_id+"deleted");
		}
		else 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("customer with ID "+user_id+" not found");
		}
	}
	
	@PutMapping("/customerup")
	public userdetails customerup(@RequestBody userdetails user)
	{
		return ser.customerup(user);
	}
	
	@GetMapping("/pagination/{num}/{size}")
	public List<userdetails>pagination(@PathVariable("num")int num,@PathVariable("size")int size)
	{
		return ser.pagination(num, size);
	}
	@GetMapping("/paginations/{num}/{size}/{name}")
	public List<userdetails>paginationAndsortingS(@PathVariable("num")int num,@PathVariable("size")int size,@PathVariable("name")String name)
	{
		return ser.paginationAndsorting(num, size,name);
	}	
	@GetMapping("/sortAsc/{name}")
	public List<userdetails>sortAsc(@PathVariable("name") String name)
	{
		return ser.sortByAsc(name);
	}
	@GetMapping("/sortdes/{name}")
	public List<userdetails>sortDsc(@PathVariable("name") String name)
	{
		return ser.sortByDes(name);
	}
}