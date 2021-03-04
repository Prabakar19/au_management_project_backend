package com.ms.au_management_project.controller;

import com.ms.au_management_project.entity.Manager;
import com.ms.au_management_project.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @PostMapping("/login")
    public ResponseEntity<Object> managerLogin(@RequestBody Map<String, String> loginMap){
        Manager manager = managerService.getManagerByEmailId(loginMap.get("emailId"));

        if(manager != null){
            if(manager.getPassword().equals(loginMap.get("password"))) {
                return new ResponseEntity<>(manager, HttpStatus.OK);
            }
            return new ResponseEntity<>("Wrong Password",HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>("No user", HttpStatus.NOT_FOUND);
    }
}
