package com.ms.au_management_project.service;

import com.ms.au_management_project.entity.TrainingMaterial;
import com.ms.au_management_project.response.TrainingMaterialResponse;

import java.util.List;

public interface TrainingMaterialService {
    public TrainingMaterialResponse addMaterial(TrainingMaterial trainingMaterial);
    public List<TrainingMaterial> findAllByAssessmentId(Integer assessId);
    public TrainingMaterialResponse updateMaterial(Integer id, TrainingMaterial trainingMaterial);
    public TrainingMaterialResponse deleteMaterial(Integer id);
}
