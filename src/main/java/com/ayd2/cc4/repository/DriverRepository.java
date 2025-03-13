package com.ayd2.cc4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayd2.cc4.model.Driver;

public interface DriverRepository extends JpaRepository<Driver, String>{

    boolean existsByName(String name);

}
