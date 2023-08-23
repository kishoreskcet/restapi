package com.example.day5.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day5.model.model;

public interface repo extends JpaRepository<model, Integer>{

//	model save(model m);

	void deleteById(int cusid);

	boolean existsById(int cusid);

//	boolean existsById(int cusid);
//
//	void deleteById(int cusid);

	@SuppressWarnings("unchecked")
	model save(model m);

	@SuppressWarnings("unchecked")
	model saveAndFlush(model m);

	Optional<model> findById(int cusid);

}