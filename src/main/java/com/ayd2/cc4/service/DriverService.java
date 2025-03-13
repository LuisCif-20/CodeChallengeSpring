package com.ayd2.cc4.service;

import java.util.List;

import com.ayd2.cc4.dto.DriverDto;
import com.ayd2.cc4.dto.UpdateDriverDto;
import com.ayd2.cc4.model.Driver;
import com.ayd2.cc4.response.DriverResponse;

public interface DriverService {
    
    DriverResponse createDriver (DriverDto newDriver);

    List<Driver> findAllDrivers();
    
    DriverResponse updateDriver(String driverId, UpdateDriverDto updateDriverDto);

    void deleteDriver(String driverId);
    
}
