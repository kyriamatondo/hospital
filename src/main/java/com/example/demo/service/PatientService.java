package com.example.demo.service;

import com.example.demo.model.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
}
