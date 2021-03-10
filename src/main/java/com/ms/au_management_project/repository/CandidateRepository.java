package com.ms.au_management_project.repository;

import com.ms.au_management_project.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    public Optional<Candidate> findCandidateByEmailId(String s);
}
