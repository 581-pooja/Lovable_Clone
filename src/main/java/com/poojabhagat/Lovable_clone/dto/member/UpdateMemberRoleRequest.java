package com.poojabhagat.Lovable_clone.dto.member;

import com.poojabhagat.Lovable_clone.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole role) {
}
