package com.vp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vp.model.Jobdetails;

public interface JobRepository extends JpaRepository<Jobdetails,Integer> {

}

