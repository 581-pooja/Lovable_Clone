package com.poojabhagat.Lovable_clone.entity;

import com.poojabhagat.Lovable_clone.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "project_members")
public class ProjectMember {
    @EmbeddedId
    ProjectMemberId id;  // Composite primary key

    @ManyToOne
    @MapsId("projectId")
    Project project;  // Many ProjectMember entries belong to ONE Project

    @ManyToOne
    @MapsId("userId")
    User user;        // Many ProjectMember entries belong to ONE User

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;
}
