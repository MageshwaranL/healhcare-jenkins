package com.healthcare.hospital.controller;

import com.healthcare.hospital.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    // Get basic statistics about patients
    @GetMapping("/patients/statistics")
    public Map<String, Long> getPatientStatistics() {
        return reportService.getPatientStatistics();
    }

    // Get basic statistics about doctors
    @GetMapping("/doctors/statistics")
    public Map<String, Long> getDoctorStatistics() {
        return reportService.getDoctorStatistics();
    }

    // Get appointment statistics
    @GetMapping("/appointments/statistics")
    public Map<String, Long> getAppointmentStatistics() {
        return reportService.getAppointmentStatistics();
    }

    // Get prescription statistics
    @GetMapping("/prescriptions/statistics")
    public Map<String, Long> getPrescriptionStatistics() {
        return reportService.getPrescriptionStatistics();
    }

    // Get appointments within a date range
    @GetMapping("/appointments/by-date")
    public Map<String, Long> getAppointmentsByDate(@RequestParam("startDate") String startDate,
                                                   @RequestParam("endDate") String endDate) {
        return reportService.getAppointmentsByDate(startDate, endDate);
    }
}
