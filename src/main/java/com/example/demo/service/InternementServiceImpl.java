package com.example.demo.service;

import com.example.demo.model.Internement;
import com.example.demo.model.Patient;
import com.example.demo.repository.InternementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class InternementServiceImpl implements InternementService {

    @Autowired
    private InternementRepository internementRepository;

    @Override
    public List<Internement> getInternementsByPatient(Patient patient) {
        return internementRepository.findByPatient(patient);
    }

    @Override
    public Internement getInternementById(Long id) {
        return internementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Internement not found with id: " + id));
    }
}
