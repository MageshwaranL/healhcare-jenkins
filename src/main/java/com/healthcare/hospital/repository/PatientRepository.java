package com.healthcare.hospital.repository;

import com.healthcare.hospital.modal.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
