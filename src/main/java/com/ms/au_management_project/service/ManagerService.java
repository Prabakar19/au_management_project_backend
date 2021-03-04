package com.ms.au_management_project.service;

import com.ms.au_management_project.entity.Manager;

public interface ManagerService {

    public Manager getManagerByEmailId(String emailId);
}
