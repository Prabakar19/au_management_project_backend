package com.ms.au_management_project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
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

    @OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "managerId")
    private Set<Assessment> assessments;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "managerId")
    private Set<Course> courses;

    public Manager(@NotNull Integer managerId, @NotNull @Size(min = 2, max = 30) String managerName, @NotNull String emailId, @NotNull String password) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.emailId = emailId;
        this.password = password;
    }
}
