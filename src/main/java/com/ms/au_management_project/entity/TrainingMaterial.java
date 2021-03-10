package com.ms.au_management_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class TrainingMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer materialId;

    private String title;


    private Integer assessmentId;

    private String docName;
    private String docType;

    @Column(name = "material")
    @JsonIgnore
    @Lob
    private byte[] material;


    public TrainingMaterial(@NotNull String title, Integer assessmentId, String docName, String docType, byte[] material) {
        this.title = title;
        this.assessmentId = assessmentId;
        this.docName = docName;
        this.docType = docType;
        this.material = material;
    }

    public TrainingMaterial(String title, Integer assessmentId) {
        this.title = title;
        this.assessmentId = assessmentId;
    }
}
