package com.ayd2.cc4.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayd2.cc4.dto.DriverDto;
import com.ayd2.cc4.model.Driver;
import com.ayd2.cc4.service.DriverService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @GetMapping()
    public ResponseEntity<List<Driver>> getAllDrivers() {
        return ResponseEntity.ok(this.driverService.getAllDrivers());
    }

    @PostMapping()
    public ResponseEntity<Driver> createDriver(DriverDto driverDto) {
        return ResponseEntity.status(201).body(this.driverService.createDriver(driverDto));
    }
    
}
