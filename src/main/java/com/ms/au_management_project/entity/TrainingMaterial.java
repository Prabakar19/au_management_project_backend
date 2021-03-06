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

    @NotNull
    private String title;

    @NotNull
    private Integer assessmentId;

    @Column(name = "material")
//    @JsonIgnore
    private byte[] material;

    public TrainingMaterial(@NotNull String title, @NotNull Integer assessmentId, @NotNull byte[] material) {
        this.title = title;
        this.assessmentId = assessmentId;
        this.material = material;
    }
}
