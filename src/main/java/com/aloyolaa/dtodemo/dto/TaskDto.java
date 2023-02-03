package com.aloyolaa.dtodemo.dto;

import com.aloyolaa.dtodemo.entity.User;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.aloyolaa.dtodemo.entity.Task} entity
 */
public record TaskDto(Long id,
                      String name,
                      Instant startDate,
                      Instant endDate) implements Serializable {
}