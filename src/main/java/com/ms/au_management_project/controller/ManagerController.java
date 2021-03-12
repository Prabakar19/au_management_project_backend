package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.ManagerDao;
import com.ms.au_management_project.entity.Manager;
import com.ms.au_management_project.response.LoginResponse;
import com.ms.au_management_project.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @PostMapping("")
    public ResponseEntity<Object> addManager(@RequestBody ManagerDao managerDao){
        Manager manager = new Manager(managerDao.getManagerId(), managerDao.getManagerName(), managerDao.getEmailId(), managerDao.getPassword());
        String response = managerService.addManager(manager);

        if(response.equals("manager added")) {
            return ResponseEntity.accepted().body("added");
        }

        return ResponseEntity.accepted().body("error");
    }

    @GetMapping("")
    public ResponseEntity<Object> getManagerById(@RequestParam Integer id){
        Manager manager = managerService.getManagerById(id);
        if(manager != null){
            return new ResponseEntity<>(manager, HttpStatus.OK);
        }
        return new ResponseEntity<>(manager, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> managerLogin(@RequestBody ManagerDao managerDao){
        LoginResponse loginResponse = managerService.getManagerByEmailId(managerDao.getEmailId());

        if(loginResponse.isValid()){
            if(loginResponse.getPassword().equals(managerDao.getPassword())) {
                return new ResponseEntity<>(loginResponse, HttpStatus.OK);
            }
            loginResponse.setMessage("Wrong Password");
            return new ResponseEntity<>(loginResponse,HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(loginResponse, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/googlelogin")
    public ResponseEntity<LoginResponse> managerGoogleLogin(@RequestBody ManagerDao managerDao){
        LoginResponse loginResponse = managerService.getManagerByEmailId(managerDao.getEmailId());

        if(loginResponse.isValid()){
                return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(loginResponse, HttpStatus.NOT_FOUND);
    }
}
