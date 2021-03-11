package com.ms.au_management_project.repository;

import com.ms.au_management_project.entity.CandidateAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CandidateAssessmentRepository extends JpaRepository<CandidateAssessment, Integer> {
    @Query("SELECT c.candidate.location,COUNT(*) FROM CandidateAssessment c WHERE c.assessment.assessmentId = ?1  GROUP BY c.candidate.location ")
    List<String> locationCount(Integer assessId);
}
