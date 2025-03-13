package com.ayd2.cc4.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateDriverDto {

    private String name;

    private int age;
    
}
