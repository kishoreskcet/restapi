package com.example.day5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

//import com.example.day5.model.model;
import com.example.day5.model.userdetails;
import com.example.day5.repo.userrepo;
//import com.example.day6.model.model;
//import com.example.day6.model.model;
//import com.example.day7.model.model;

//import jakarta.transaction.Transactional;

@Service
public class userservice {

	@Autowired
	public userrepo repo;
	
	public userdetails details(userdetails user)
	{
		return repo.save(user);
	}
	
	public List<userdetails> getDetails()
	{
		return repo.findAll();
	}
	
	//delete
		public void delete(int user_id)
		{
			System.out.println("Deleted");
			repo.deleteById(user_id);
		}
		
		public boolean customerinfo(int user_id)
		{
			if(repo.existsById(user_id))
			{
				repo.deleteById(user_id);
				return true;
			}
			return false;
		}
		
		
		public  userdetails customerup(userdetails user)
		{
			return repo.saveAndFlush(user);
		}
		public List<userdetails> sortByAsc(String name)
		{
			return repo.findAll(Sort.by(name).ascending());
		}
		public List<userdetails> sortByDes(String name)
		{
			return repo.findAll(Sort.by(name).descending());

		}
		
		public List<userdetails>pagination(int pagno,int pagesize)
		{
			Page<userdetails> cont=repo.findAll(PageRequest.of(pagno, pagesize));
			return cont.getContent();
		}
		
		public List<userdetails>paginationandsorting(int pagno,int pagesize,String name)
		{
			Page<userdetails> cont=repo.findAll(PageRequest.of(pagno, pagesize,Sort.by(name).ascending()));
			return cont.getContent();
		}
		
		public List<userdetails>paginationAndsorting(int pagno,int pagesize,String name)
		{
			Page<userdetails> cont=repo.findAll(PageRequest.of(pagno, pagesize,Sort.by(name).descending()));
			return cont.getContent();
		}
}