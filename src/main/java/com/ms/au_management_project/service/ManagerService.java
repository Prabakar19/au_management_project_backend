package com.ms.au_management_project.service;

import com.ms.au_management_project.entity.Manager;
import com.ms.au_management_project.response.LoginResponse;

public interface ManagerService {

    public String addManager(Manager manager);
    public LoginResponse getManagerByEmailId(String emailId);
    public Manager getManagerById(Integer id);
}
