package com.example.demo.service;


import com.example.demo.model.Internement;
import com.example.demo.model.Patient;

import java.util.List;

public interface InternementService {
    List<Internement> getInternementsByPatient(Patient patient);
    Internement getInternementById(Long id);
}



