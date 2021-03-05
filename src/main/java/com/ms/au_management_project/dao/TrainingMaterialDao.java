package com.ms.au_management_project.dao;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TrainingMaterialDao {

    private Integer materialId;

    private String title;

    private Integer assessmentId;

    private byte[] material;
}
