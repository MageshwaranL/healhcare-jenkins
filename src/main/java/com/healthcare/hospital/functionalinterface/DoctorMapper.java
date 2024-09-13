package com.healthcare.hospital.functionalinterface;

import com.healthcare.hospital.dto.DoctorDTO;
import com.healthcare.hospital.modal.Doctor;

import java.util.function.Function;

@FunctionalInterface
public interface DoctorMapper extends Function<Doctor, DoctorDTO> {
    // We can use Function's apply method to map Doctor to DoctorDTO
}
