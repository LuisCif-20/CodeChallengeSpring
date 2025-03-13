package com.ayd2.cc4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayd2.cc4.dto.DriverDto;
import com.ayd2.cc4.dto.UpdateDriverDto;
import com.ayd2.cc4.model.Driver;
import com.ayd2.cc4.repository.DriverRepository;
import com.ayd2.cc4.response.DriverResponse;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    @Autowired
    private final DriverRepository driverRepository;

    @Override
    public DriverResponse createDriver(DriverDto driverDto) {
        if (this.driverRepository.existsByName(driverDto.getName())) {
            throw new IllegalArgumentException("Driver is already exists");
        }
        final Driver driver = new Driver();
        driver.setName(driverDto.getName());
        driver.setAge(driverDto.getAge());
        return new DriverResponse(this.driverRepository.save(driver));
    }

    @Override
    public List<Driver> findAllDrivers() {
        return this.driverRepository.findAll();
    }

    @Override
    public DriverResponse updateDriver(String driverId, UpdateDriverDto updateDriverDto) {
        Driver driver = this.driverRepository.findById(driverId).orElseThrow(() -> new EntityNotFoundException("Driver not found."));
        if (!updateDriverDto.getName().equals(null)) {
            if (this.driverRepository.existsByName(updateDriverDto.getName())) {
                throw new IllegalArgumentException("Driver is already exists");
            }
            driver.setName(updateDriverDto.getName());
        }
        if (!((Integer)updateDriverDto.getAge()).equals(null)) {
            driver.setAge(updateDriverDto.getAge());
        }
        return new DriverResponse(this.driverRepository.save(driver));
    }

    @Override
    public void deleteDriver(String driverId) {
        this.driverRepository.deleteById(driverId);
    }

}
