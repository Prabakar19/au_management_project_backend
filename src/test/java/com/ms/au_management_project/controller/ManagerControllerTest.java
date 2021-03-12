package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.CandidateDao;
import com.ms.au_management_project.dao.CourseDao;
import com.ms.au_management_project.dao.ManagerDao;
import com.ms.au_management_project.entity.Manager;
import com.ms.au_management_project.response.LoginResponse;
import com.ms.au_management_project.service.ManagerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ManagerControllerTest {

    @InjectMocks
    ManagerController managerController;

    @Mock
    ManagerService managerService;

    @Test
    void addManager() {
        String response = "manager added";

        //success
        ManagerDao managerDao = new ManagerDao();
        Mockito.when(managerService.addManager(Mockito.any())).thenReturn(response);
        Assertions.assertEquals("added", Objects.requireNonNull(managerController.addManager(managerDao).getBody()));

        //failure
        response = "error";
        Mockito.when(managerService.addManager(Mockito.any())).thenReturn(response);
        Assertions.assertEquals( "error", Objects.requireNonNull(managerController.addManager(managerDao).getBody()));
    }

    @Test
    void getManagerById() {
        Manager manager = new Manager();
        Mockito.when(managerService.getManagerById(Mockito.any())).thenReturn(manager);
        ResponseEntity<Object> responseEntity = managerController.getManagerById(Mockito.any());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());


        Mockito.when(managerService.getManagerById(Mockito.any())).thenReturn(null);
        ResponseEntity<Object> responseEntity1 = managerController.getManagerById(1);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, responseEntity1.getStatusCode());
    }

    @Test
    void managerLogin() {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setValid(true);
        loginResponse.setPassword("12345");
        ManagerDao managerDao = new ManagerDao();


        Mockito.when(managerService.getManagerByEmailId(Mockito.any())).thenReturn(loginResponse);
        Assertions.assertEquals("12345", Objects.requireNonNull(managerController.managerLogin(managerDao).getBody()).getPassword());

        loginResponse.setPassword("12346");
        managerDao.setPassword("12345");
        Assertions.assertNotEquals("12345", Objects.requireNonNull(managerController.managerLogin(managerDao).getBody()).getPassword());

        loginResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(managerController.managerLogin(managerDao).getBody()).isValid());
    }

    @Test
    void managerGoogleLogin() {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setValid(true);
        ManagerDao managerDao = new ManagerDao();
        Mockito.when(managerService.getManagerByEmailId(Mockito.any())).thenReturn(loginResponse);
        Assertions.assertTrue(Objects.requireNonNull(managerController.managerGoogleLogin(managerDao).getBody()).isValid());


        loginResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(managerController.managerGoogleLogin(managerDao).getBody()).isValid());
    }
}