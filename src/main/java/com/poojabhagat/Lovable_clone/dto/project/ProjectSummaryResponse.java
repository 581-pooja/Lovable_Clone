package com.poojabhagat.Lovable_clone.dto.project;

import com.poojabhagat.Lovable_clone.enums.ProjectRole;

import java.time.Instant;

public record ProjectSummaryResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        ProjectRole role
) {
}
