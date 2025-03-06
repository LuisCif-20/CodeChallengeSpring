package com.ayd2.cc4.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ayd2.cc4.dto.DriverDto;
import com.ayd2.cc4.model.Driver;
import com.ayd2.cc4.repository.DriverRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DriverService {
    
    private final DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return this.driverRepository.findAll();
    }

    public Driver createDriver(final DriverDto driverDto) {
        final Driver driver = new Driver();
        driver.setName(driverDto.getName());
        driver.setAge(driverDto.getAge());
        return this.driverRepository.save(driver);
    }

}
