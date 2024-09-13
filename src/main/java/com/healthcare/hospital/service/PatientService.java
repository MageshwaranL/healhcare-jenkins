package com.healthcare.hospital.service;

import com.healthcare.hospital.functionalinterface.PatientFilter;
import com.healthcare.hospital.modal.Patient;
import com.healthcare.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> getPatientsByName(String name) {
        return patientRepository.findAll().stream()
                .filter(patient -> patient.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // Method using the custom PatientFilter functional interface
    public List<Patient> filterPatients(PatientFilter filter) {
        return patientRepository.findAll().stream()
                .filter(filter)
                .collect(Collectors.toList());
    }

    // Method to apply a function to transform patient data
    public List<String> getPatientNames(Function<Patient, String> nameExtractor) {
        return patientRepository.findAll().stream()
                .map(nameExtractor)
                .collect(Collectors.toList());
    }

}
