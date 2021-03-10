package com.ms.au_management_project.Impl;

import com.ms.au_management_project.entity.Manager;
import com.ms.au_management_project.repository.ManagerRepository;
import com.ms.au_management_project.response.LoginResponse;
import com.ms.au_management_project.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public String addManager(Manager manager) {
        try{
            managerRepository.save(manager);
            return "manager added";
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public LoginResponse getManagerByEmailId(String emailId) {
        Optional<Manager> optionalManager = managerRepository.findManagerByEmailId(emailId);
        if (optionalManager.isPresent()) {
            Manager manager = optionalManager.get();
            return new LoginResponse(true, "authorized user", manager.getManagerId(), manager.getManagerName(), manager.getEmailId(), manager.getPassword());
        }

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setValid(false);
        loginResponse.setMessage("unauthorized user");
        return loginResponse;
    }

    @Override
    public Manager getManagerById(Integer id) {
        try {
            Optional<Manager> optionalManager = managerRepository.findById(id);

            if (optionalManager.isPresent()) {
                return optionalManager.get();
            }

        }catch (Exception e){
            return null;
        }
        return null;
    }
}
