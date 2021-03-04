package com.ms.au_management_project.Impl;

import com.ms.au_management_project.entity.Manager;
import com.ms.au_management_project.repository.ManagerRepository;
import com.ms.au_management_project.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerRepository managerRepository;

    public Manager getManagerByEmailId(String emailId) {
        Optional<Manager> optionalManager = managerRepository.findManagerByEmailId(emailId);
        if (optionalManager.isPresent()) {
            return optionalManager.get();
        }
        return null;
    }
}
