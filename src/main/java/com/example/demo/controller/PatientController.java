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
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private InternementService internementService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        return ResponseEntity.ok(patient);
    }

    @GetMapping("/{patientId}/internements")
    public List<Internement> getIntenementsByPatient(@PathVariable Long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        return internementService.getInternementsByPatient(patient);
    }
}
