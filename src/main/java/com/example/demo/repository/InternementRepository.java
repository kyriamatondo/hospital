package com.example.demo.repository;

import com.example.demo.model.Internement;
import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InternementRepository extends JpaRepository<Internement, Long> {
    List<Internement> findByPatient(Patient patient);
}
