package com.Snehanand.service;

import com.Snehanand.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    public void addPatient(Patient patient) {

        System.out.println(patient.getName());

    }
}