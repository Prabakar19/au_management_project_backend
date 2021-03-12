package com.ms.au_management_project.impl;

import com.ms.au_management_project.entity.Manager;
import com.ms.au_management_project.repository.ManagerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ManagerServiceImplTest {

    @InjectMocks
    ManagerServiceImpl managerService;

    @Mock
    ManagerRepository managerRepository;

    @Test
    void addManager() {
        Mockito.when(managerRepository.save(Mockito.any())).thenReturn(Mockito.any());
        Assertions.assertEquals("manager added", managerService.addManager(new Manager()));

        Assertions.assertNull(managerService.addManager(null));
    }

    @Test
    void getManagerByEmailId() {
        //failure
        Mockito.when(managerRepository.findManagerByEmailId(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertFalse(managerService.getManagerByEmailId("dummy@mail.com").isValid());
        //success
        Mockito.when(managerRepository.findManagerByEmailId(Mockito.any())).thenReturn(Optional.of(new Manager()));
        Assertions.assertTrue(managerService.getManagerByEmailId("dummy@mail.com").isValid());
    }

    @Test
    void getManagerById() {
        //success
        Mockito.when(managerRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertNull(managerService.getManagerById(1));
        //failure
        Mockito.when(managerRepository.findById(Mockito.any())).thenReturn(Optional.of(new Manager()));
        Assertions.assertNotNull(managerService.getManagerById(1));
    }
}