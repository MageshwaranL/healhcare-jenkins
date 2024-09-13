package com.healthcare.hospital.repository;

import com.healthcare.hospital.modal.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
