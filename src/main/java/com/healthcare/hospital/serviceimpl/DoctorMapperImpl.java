package com.healthcare.hospital.serviceimpl;

import com.healthcare.hospital.dto.DoctorDTO;
import com.healthcare.hospital.functionalinterface.DoctorMapper;
import com.healthcare.hospital.modal.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapperImpl implements DoctorMapper {
    @Override
    public DoctorDTO apply(Doctor doctor) {
        DoctorDTO dto = new DoctorDTO();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setSpecialty(doctor.getSpecialty());
        return dto;
    }
}
