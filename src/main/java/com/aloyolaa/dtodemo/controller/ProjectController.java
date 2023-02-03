package com.aloyolaa.dtodemo.controller;

import com.aloyolaa.dtodemo.dto.ProjectDto;
import com.aloyolaa.dtodemo.dto.ProjectSave;
import com.aloyolaa.dtodemo.entity.Project;
import com.aloyolaa.dtodemo.service.ProjectService;
import com.aloyolaa.dtodemo.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/find/{name}")
    public ResponseEntity<List<ProjectDto>> findByName(@PathVariable String name) {
        return new ResponseEntity<>(projectService.findByName(name), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ProjectDto> save(@RequestBody @Valid ProjectSave projectSave) {
        return new ResponseEntity<>(projectService.save(projectSave), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ProjectDto> update(@RequestBody @Valid ProjectDto projectDto) {
        return new ResponseEntity<>(projectService.update(projectDto), HttpStatus.CREATED);
    }
}
