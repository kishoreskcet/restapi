package com.day4.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.day4.model.model;

public interface repo extends JpaRepository<model, Integer>{

}
