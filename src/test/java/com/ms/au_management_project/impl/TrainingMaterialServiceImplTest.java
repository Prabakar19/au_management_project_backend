package com.ms.au_management_project.impl;

import com.ms.au_management_project.dao.TrainingMaterialDao;
import com.ms.au_management_project.entity.TrainingMaterial;
import com.ms.au_management_project.repository.TrainingMaterialRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class TrainingMaterialServiceImplTest {

    @InjectMocks
    TrainingMaterialServiceImpl trainingMaterialService;

    @Mock
    TrainingMaterialRepository trainingMaterialRepository;


    @Test
    void addMaterial() {
        Mockito.when(trainingMaterialRepository.save(Mockito.any())).thenReturn(new TrainingMaterial());
        Assertions.assertTrue(trainingMaterialService.addMaterial(new TrainingMaterialDao()).isValid());

        Assertions.assertFalse(trainingMaterialService.addMaterial(null).isValid());

    }

    @Test
    void findAllByAssessmentId() {
        List<TrainingMaterial> trainingMaterialList = new ArrayList<>();
        //success
        Mockito.when(trainingMaterialRepository.findAllByAssessmentId(Mockito.any())).thenReturn(trainingMaterialList);
        Assertions.assertEquals(trainingMaterialList, trainingMaterialService.findAllByAssessmentId(1));
    }

    @Test
    void updateMaterial() {
        Mockito.when(trainingMaterialRepository.findById(Mockito.any())).thenReturn(Optional.of(new TrainingMaterial()));
        Assertions.assertTrue(trainingMaterialService.updateMaterial(1, new TrainingMaterialDao()).isValid());

        Mockito.when(trainingMaterialRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertFalse(trainingMaterialService.updateMaterial(1, new TrainingMaterialDao()).isValid());

        Assertions.assertFalse(trainingMaterialService.updateMaterial(1, null).isValid());
    }

    @Test
    void deleteMaterial() {

        Mockito.when(trainingMaterialRepository.findById(Mockito.any())).thenReturn(Optional.of(new TrainingMaterial()));
        Assertions.assertTrue(trainingMaterialService.deleteMaterial(1).isValid());

        Mockito.when(trainingMaterialRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertFalse(trainingMaterialService.deleteMaterial(1).isValid());
    }

    @Test
    void getMaterial() {
        Mockito.when(trainingMaterialRepository.findById(Mockito.any())).thenReturn(Optional.of(new TrainingMaterial()));
        Assertions.assertNotNull(trainingMaterialService.getMaterial(1));

        Mockito.when(trainingMaterialRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertNull(trainingMaterialService.getMaterial(1));
    }
}