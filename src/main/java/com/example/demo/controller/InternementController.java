package com.example.demo.controller;

import com.example.demo.model.Internement;
import com.example.demo.model.Patient;
import com.example.demo.service.InternementService;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/internements")
public class InternementController {

    @Autowired
    private InternementService internementService;

    @Autowired
    private PatientService patientService;

    @GetMapping("/{internementId}")
    public ResponseEntity<Internement> getInternementById(@PathVariable Long internementId) {
        Internement internement = internementService.getInternementById(internementId);
        return ResponseEntity.ok(internement);
    }

    @GetMapping("/patient/{patientId}")
    public List<Internement> getInternementsByPatient(@PathVariable Long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        return internementService.getInternementsByPatient(patient);
    }
}


