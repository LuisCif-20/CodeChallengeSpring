package com.ayd2.cc4.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayd2.cc4.dto.DriverDto;
import com.ayd2.cc4.dto.UpdateDriverDto;
import com.ayd2.cc4.model.Driver;
import com.ayd2.cc4.response.DriverResponse;
import com.ayd2.cc4.service.DriverServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {

    private final DriverServiceImpl driverServiceImpl;

    @GetMapping()
    public ResponseEntity<List<Driver>> getAllDrivers() {
        return ResponseEntity.ok(this.driverServiceImpl.findAllDrivers());
    }

    @PostMapping()
    public ResponseEntity<DriverResponse> createDriver(@RequestBody @Valid DriverDto driverDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.driverServiceImpl.createDriver(driverDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DriverResponse> updateDriver(@PathVariable String id, @RequestBody @Valid UpdateDriverDto updateDriverDto) {
        return ResponseEntity.ok(this.driverServiceImpl.updateDriver(id, updateDriverDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable String id) {
        this.driverServiceImpl.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }
    
}
