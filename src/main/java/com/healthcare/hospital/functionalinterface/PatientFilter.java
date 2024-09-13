package com.healthcare.hospital.functionalinterface;

import com.healthcare.hospital.modal.Patient;

import java.util.function.Predicate;

@FunctionalInterface
public interface PatientFilter extends Predicate<Patient> {
    // We can use Predicate's test method for filtering
}
