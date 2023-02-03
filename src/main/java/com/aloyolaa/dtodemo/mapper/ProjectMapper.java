package com.aloyolaa.dtodemo.mapper;

import com.aloyolaa.dtodemo.dto.ProjectDto;
import com.aloyolaa.dtodemo.dto.ProjectSave;
import com.aloyolaa.dtodemo.entity.Project;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProjectMapper {
    Project toEntity(ProjectDto projectDto);

    ProjectDto toDto(Project project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project partialUpdate(ProjectDto projectDto, @MappingTarget Project project);

    @AfterMapping
    default void linkTasks(@MappingTarget Project project) {
        project.getTasks().forEach(task -> task.setProject(project));
    }

    Project toEntity(ProjectSave projectSave);

    ProjectSave toSaveDto(Project project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project partialUpdateSaveDto(ProjectSave projectSave, @MappingTarget Project project);
}