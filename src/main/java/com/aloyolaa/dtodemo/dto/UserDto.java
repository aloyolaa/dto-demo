package com.aloyolaa.dtodemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * A DTO for the {@link com.aloyolaa.dtodemo.entity.User} entity
 */
public record UserDto(Long id,
                      @NotBlank @Size(max = 255) String name,
                      @Email String email) implements Serializable {
}