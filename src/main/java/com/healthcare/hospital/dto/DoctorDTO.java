package com.healthcare.hospital.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoctorDTO {
    private Long id;
    private String name;
    private String specialty;

    // Constructors, getters, setters
}
