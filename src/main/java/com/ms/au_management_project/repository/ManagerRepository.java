package com.ms.au_management_project.repository;

import com.ms.au_management_project.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    public Optional<Manager> findManagerByEmailId(String s);
}
