package com.ms.au_management_project.repository;

import com.ms.au_management_project.entity.TrainingMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingMaterialRepository extends JpaRepository<TrainingMaterial, Integer> {
    public List<TrainingMaterial> findAllByAssessmentId(Integer id);
}
