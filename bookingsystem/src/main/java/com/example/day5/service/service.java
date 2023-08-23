package com.example.day5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day5.model.model;
import com.example.day5.repo.repo;

@Service

public class service {
	
	@Autowired
	public repo rep;
	
	//post
	public model savebookingModel(model m)
	{
		return rep.save(m);
	}
	
	//get
	public List<model> getDetails()
	{
		return rep.findAll();
	}
	
	//delete
	public void delete(int cusid)
	{
		System.out.println("Deleted");
		rep.deleteById(cusid);
	}
	
	
	public boolean customerinfo(int cusid)
	{
		if(rep.existsById(cusid))
		{
			rep.deleteById(cusid);
			return true;
		}
		return false;
	}
	
	//update
	public model customerup(model m)
	{
		return rep.saveAndFlush(m);
	}
	
	//get by user id
	public Optional<model> getUserId(int cusid)
	{
		Optional<model>customer=rep.findById(cusid);
		if(customer.isPresent())
		{
			return customer;
		}
		return null;
	}
	
	public boolean updateStudInfo(int cusid)
	{
		if(rep.existsById(cusid))
		{
			return true;
		}
		return false;
	}
}