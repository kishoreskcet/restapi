package com.example.day5.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day5.model.busmodel;
//import com.example.day5.model.userdetails;

public interface busrepo extends JpaRepository<busmodel, Integer>{



}