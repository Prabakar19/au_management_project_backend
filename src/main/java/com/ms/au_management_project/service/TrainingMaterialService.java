package com.ms.au_management_project.service;

import com.ms.au_management_project.dao.TrainingMaterialDao;
import com.ms.au_management_project.entity.TrainingMaterial;
import com.ms.au_management_project.response.TrainingMaterialResponse;

import java.util.List;

public interface TrainingMaterialService {
    public TrainingMaterialResponse addMaterial(TrainingMaterialDao trainingMaterialDao);
    public List<TrainingMaterial> findAllByAssessmentId(Integer assessId);
    public TrainingMaterialResponse updateMaterial(Integer id, TrainingMaterialDao trainingMaterialDao);
    public TrainingMaterialResponse deleteMaterial(Integer id);

    public TrainingMaterial getMaterial(Integer id);
}
