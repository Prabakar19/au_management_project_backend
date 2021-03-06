package com.ms.au_management_project.dao;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class TrainingMaterialDao {

    private Integer materialId;

    private String title;

    private Integer assessmentId;

    private MultipartFile material;
}
