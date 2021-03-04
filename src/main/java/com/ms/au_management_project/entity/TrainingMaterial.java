package com.ms.au_management_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
public class TrainingMaterial {

    @Id
    @NotNull
    private Integer materialId;

    @NotNull
    private String title;

    @NotNull
    private Integer assessmentId;

    @Column(name = "material")
    @NotNull
    private byte[] material;

}
