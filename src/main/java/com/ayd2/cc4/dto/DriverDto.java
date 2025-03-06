package com.ayd2.cc4.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DriverDto {
    
    @NotBlank(message = "Driver name is required")
    private String name;

    @NotBlank(message = "Age driver is required")
    private int age;
    

}
