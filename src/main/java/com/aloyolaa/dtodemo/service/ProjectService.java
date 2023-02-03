package com.aloyolaa.dtodemo.service;

import com.aloyolaa.dtodemo.dto.ProjectDto;
import com.aloyolaa.dtodemo.dto.ProjectSave;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> findByName(String name);

    ProjectDto save(ProjectSave projectSave);

    ProjectDto update(ProjectDto projectDto);
}
