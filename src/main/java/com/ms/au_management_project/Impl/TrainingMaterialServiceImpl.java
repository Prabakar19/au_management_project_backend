package com.ms.au_management_project.Impl;

import com.ms.au_management_project.dao.TrainingMaterialDao;
import com.ms.au_management_project.entity.TrainingMaterial;
import com.ms.au_management_project.repository.TrainingMaterialRepository;
import com.ms.au_management_project.response.TrainingMaterialResponse;
import com.ms.au_management_project.service.TrainingMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingMaterialServiceImpl implements TrainingMaterialService {

    @Autowired
    TrainingMaterialRepository trainingMaterialRepository;



    @Override
    public TrainingMaterialResponse addMaterial(TrainingMaterialDao trainingMaterialDao) {
//        String docName = trainingMaterialDao.getMaterial().getOriginalFilename();
        try{
            TrainingMaterial trainingMaterial = new TrainingMaterial(trainingMaterialDao.getTitle(), trainingMaterialDao.getAssessmentId());
            TrainingMaterial trainingMaterial1 = trainingMaterialRepository.save(trainingMaterial);
            return new TrainingMaterialResponse(true, "material added", trainingMaterial1.getMaterialId(), trainingMaterial1.getTitle(), trainingMaterial1.getAssessmentId(), trainingMaterial1.getMaterial());
        }catch(Exception e){
            TrainingMaterialResponse trainingMaterialResponse = new TrainingMaterialResponse();
            trainingMaterialResponse.setMaterialId(0);
            trainingMaterialResponse.setValid(false);
            trainingMaterialResponse.setMessage("not added");
            return trainingMaterialResponse;
        }
    }

    @Override
    public List<TrainingMaterial> findAllByAssessmentId(Integer assessId) {
        return trainingMaterialRepository.findAllByAssessmentId(assessId);
    }

    @Override
    public TrainingMaterialResponse updateMaterial(Integer id, TrainingMaterialDao trainingMaterialDao) {

        String docName = trainingMaterialDao.getMaterial().getOriginalFilename();
        try {
            TrainingMaterial trainingMaterial = new TrainingMaterial(trainingMaterialDao.getTitle(), trainingMaterialDao.getAssessmentId(), docName, trainingMaterialDao.getMaterial().getContentType(), trainingMaterialDao.getMaterial().getBytes());
            Optional<TrainingMaterial> optionalTrainingMaterial = trainingMaterialRepository.findById(id);

        if(optionalTrainingMaterial.isPresent()){
            TrainingMaterial trainingMaterial1 = optionalTrainingMaterial.get();

            trainingMaterial1.setTitle(trainingMaterial.getTitle());
            trainingMaterial1.setMaterial(trainingMaterial.getMaterial());
            trainingMaterialRepository.save(trainingMaterial1);
            return new TrainingMaterialResponse(true, "material updated", trainingMaterial1.getMaterialId(), trainingMaterial1.getTitle(), trainingMaterial1.getAssessmentId(), trainingMaterial1.getMaterial());
        }
        }catch (Exception e){
            e.printStackTrace();
        }

        TrainingMaterialResponse trainingMaterialResponse = new TrainingMaterialResponse();
        trainingMaterialResponse.setMaterialId(id);
        trainingMaterialResponse.setValid(false);
        trainingMaterialResponse.setMessage("material id is not present");
        return trainingMaterialResponse;
    }

    @Override
    public TrainingMaterialResponse deleteMaterial(Integer id) {
        Optional<TrainingMaterial> optionalTrainingMaterial = trainingMaterialRepository.findById(id);

        TrainingMaterialResponse trainingMaterialResponse = new TrainingMaterialResponse();
        if(optionalTrainingMaterial.isPresent()) {
            trainingMaterialRepository.deleteById(id);
            trainingMaterialResponse.setMaterialId(id);
            trainingMaterialResponse.setValid(true);
            trainingMaterialResponse.setMessage("successfully deleted");
        }

        trainingMaterialResponse.setMaterialId(id);
        trainingMaterialResponse.setValid(false);
        trainingMaterialResponse.setMessage("material not present");
        return trainingMaterialResponse;
    }

    @Override
    public TrainingMaterial getMaterial(Integer id){
        Optional<TrainingMaterial> optionalTrainingMaterial = trainingMaterialRepository.findById(id);
        return optionalTrainingMaterial.orElse(null);
    }
}
