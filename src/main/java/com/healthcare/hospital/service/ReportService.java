package com.healthcare.hospital.service;

import com.healthcare.hospital.modal.Appointment;
import com.healthcare.hospital.repository.AppointmentRepository;
import com.healthcare.hospital.repository.DoctorRepository;
import com.healthcare.hospital.repository.PatientRepository;
import com.healthcare.hospital.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    // Get basic statistics about patients
    public Map<String, Long> getPatientStatistics() {
        long totalPatients = patientRepository.count();
        // Example: You could add more complex statistics here
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalPatients", totalPatients);
        return stats;
    }

    // Get basic statistics about doctors
    public Map<String, Long> getDoctorStatistics() {
        long totalDoctors = doctorRepository.count();
        // Example: You could add more complex statistics here
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalDoctors", totalDoctors);
        return stats;
    }

    // Get appointment statistics
    public Map<String, Long> getAppointmentStatistics() {
        long totalAppointments = appointmentRepository.count();
        // Example: You could add more complex statistics here
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalAppointments", totalAppointments);
        return stats;
    }

    // Get prescription statistics
    public Map<String, Long> getPrescriptionStatistics() {
        long totalPrescriptions = prescriptionRepository.count();
        // Example: You could add more complex statistics here
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalPrescriptions", totalPrescriptions);
        return stats;
    }

    // Get appointments within a date range
    public Map<String, Long> getAppointmentsByDate(String startDate, String endDate) {
        List<Appointment> appointments = appointmentRepository.findAll().stream()
                .filter(a -> a.getAppointmentTime().isAfter(LocalDateTime.parse(startDate))
                        && a.getAppointmentTime().isBefore(LocalDateTime.parse(endDate)))
                .collect(Collectors.toList());

        Map<String, Long> stats = new HashMap<>();
        stats.put("appointmentsInRange", (long) appointments.size());
        return stats;
    }
}
