package com.poojabhagat.Lovable_clone.service;

import com.poojabhagat.Lovable_clone.dto.deploy.DeployResponse;

public interface DeploymentService {
    DeployResponse deploy(Long projectId);
}
