package com.poojabhagat.Lovable_clone.mapper;

import com.poojabhagat.Lovable_clone.dto.project.ProjectResponse;
import com.poojabhagat.Lovable_clone.dto.project.ProjectSummaryResponse;
import com.poojabhagat.Lovable_clone.entity.Project;
import com.poojabhagat.Lovable_clone.enums.ProjectRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

//    @Mapping(target = "projectName", source = "name") // mapping source table : name to target table : projectName
    ProjectSummaryResponse toProjectSummaryResponse(Project project, ProjectRole role);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);
}
