package com.healthcare.hospital.repository;

import com.healthcare.hospital.modal.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByAppointmentTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
}
