package com.aloyolaa.dtodemo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * A DTO for the {@link com.aloyolaa.dtodemo.entity.Project} entity
 */
public record ProjectSave(@NotBlank @Size(max = 255) String name,
                          Instant startDate,
                          Instant endDate,
                          UserDto user,
                          List<TaskDto> tasks) implements Serializable {
    /**
     * A DTO for the {@link com.aloyolaa.dtodemo.entity.User} entity
     */
    public record UserDto(Long id) implements Serializable {
    }
}