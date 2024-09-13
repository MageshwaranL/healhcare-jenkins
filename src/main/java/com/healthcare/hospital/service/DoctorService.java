package com.healthcare.hospital.service;

import com.healthcare.hospital.dto.DoctorDTO;
import com.healthcare.hospital.functionalinterface.DoctorMapper;
import com.healthcare.hospital.modal.Doctor;
import com.healthcare.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
    public List<DoctorDTO> getAllDoctorDTOs(DoctorMapper mapper) {
        return doctorRepository.findAll().stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}
