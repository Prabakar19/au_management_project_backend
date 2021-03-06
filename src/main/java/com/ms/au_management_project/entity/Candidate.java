package com.ms.au_management_project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Candidate {

    @Id
    @NotNull
    private Integer candidateId;

    @NotNull
    @Size(min = 2, max = 30)
    private String candidateName;

    @NotNull
    private Date joinDate;

    @Column(unique = true)
    private String emailId;

    @NotNull
    private String location;
}
