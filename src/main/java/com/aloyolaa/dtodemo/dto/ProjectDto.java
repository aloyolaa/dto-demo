package com.aloyolaa.dtodemo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.aloyolaa.dtodemo.entity.Project} entity
 */
public record ProjectDto(Long id,
                         @NotBlank @Size(max = 255) String name,
                         UserDto user,
                         List<TaskDto> tasks) implements Serializable {
}