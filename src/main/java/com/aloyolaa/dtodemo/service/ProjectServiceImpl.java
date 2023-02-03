package com.aloyolaa.dtodemo.service;

import com.aloyolaa.dtodemo.dto.ProjectDto;
import com.aloyolaa.dtodemo.dto.ProjectSave;
import com.aloyolaa.dtodemo.entity.Project;
import com.aloyolaa.dtodemo.mapper.ProjectMapper;
import com.aloyolaa.dtodemo.repository.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProjectDto> findByName(String name) {
        return projectRepository.findByNameContainsIgnoreCase(name)
                .stream()
                .map(projectMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public ProjectDto save(ProjectSave projectSave) {
        Project project = projectMapper.toEntity(projectSave);
        project.setUser(userService.findById(projectSave.user().id()));
        return projectMapper.toDto(projectRepository.save(project));
    }

    @Override
    @Transactional
    public ProjectDto update(ProjectDto projectDto) {
        if (projectDto.id() == null) {
            throw new IllegalArgumentException();
        }
        Project project = projectRepository.findById(projectDto.id()).orElseThrow(EntityNotFoundException::new);
        Project updatedProject = projectMapper.partialUpdate(projectDto, project);
        return projectMapper.toDto(projectRepository.save(updatedProject));
    }
}
