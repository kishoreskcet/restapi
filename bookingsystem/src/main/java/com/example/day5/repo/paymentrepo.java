package com.example.day5.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day5.model.paymentmodel;

public interface paymentrepo extends JpaRepository<paymentmodel, Integer>{

}