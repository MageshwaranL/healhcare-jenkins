package com.healthcare.hospital.controller;

import com.healthcare.hospital.modal.Patient;
import com.healthcare.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        patient.setId(id);
        return patientService.savePatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }


    @GetMapping("/filter")
    public List<Patient> filterPatients(@RequestParam String name) {
        return patientService.filterPatients(patient -> patient.getName().equalsIgnoreCase(name));
    }

    @GetMapping("/names")
    public List<String> getPatientNames() {
        return patientService.getPatientNames(Patient::getName);
    }
}
