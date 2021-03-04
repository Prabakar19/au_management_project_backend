package com.ms.au_management_project.dao;

import com.ms.au_management_project.entity.Assessment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ManagerDao {

    private Integer managerId;

    private String managerName;

    private String emailId;

    private String password;

    private Set<Assessment> assessments;
}