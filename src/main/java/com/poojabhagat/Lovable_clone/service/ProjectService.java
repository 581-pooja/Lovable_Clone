package com.poojabhagat.Lovable_clone.service;

import com.poojabhagat.Lovable_clone.dto.project.ProjectRequest;
import com.poojabhagat.Lovable_clone.dto.project.ProjectSummaryResponse;
import com.poojabhagat.Lovable_clone.dto.project.ProjectResponse;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects();

    ProjectSummaryResponse getUserProjectById(Long id);

    ProjectResponse createProject(ProjectRequest request);

    ProjectResponse updateProject(Long id, ProjectRequest request);

    void softDelete(Long id);
}
