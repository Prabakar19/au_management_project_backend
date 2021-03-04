package com.ms.au_management_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Entity
public class Manager {

    @Id
    @NotNull
    private Integer managerId;

    @NotNull
    @Size(min = 2, max = 30)
    private String managerName;

    @NotNull
    @Column(unique = true)
    private String emailId;

    @NotNull
    private String password;

    @OneToMany(mappedBy = "managerId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Assessment> assessments;

}
