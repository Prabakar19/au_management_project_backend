package com.ms.au_management_project.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TrainingMaterialResponse {

    private boolean valid;

    private String message;

    private Integer materialId;

    private String title;

    private Integer assessmentId;

    private byte[] material;

    public TrainingMaterialResponse(boolean valid, String message, Integer materialId, String title, Integer assessmentId, byte[] material) {
        this.valid = valid;
        this.message = message;
        this.materialId = materialId;
        this.title = title;
        this.assessmentId = assessmentId;
        this.material = material;
    }
}
