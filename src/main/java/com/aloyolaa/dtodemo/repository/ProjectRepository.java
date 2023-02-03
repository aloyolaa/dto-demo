package com.aloyolaa.dtodemo.repository;

import com.aloyolaa.dtodemo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByNameContainsIgnoreCase(String name);
}