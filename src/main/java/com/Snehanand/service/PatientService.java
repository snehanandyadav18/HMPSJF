package com.Snehanand.service;

import com.Snehanand.model.Patient;
import com.Snehanand.repository.PatientRepository;

import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public void addPatient(Patient patient) {
        repository.save(patient);
    }
}