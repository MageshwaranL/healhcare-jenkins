package com.healthcare.hospital.repository;

import com.healthcare.hospital.modal.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
