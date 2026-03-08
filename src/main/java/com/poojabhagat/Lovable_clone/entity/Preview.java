package com.poojabhagat.Lovable_clone.entity;

import com.poojabhagat.Lovable_clone.enums.PreviewStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Preview {
    Long id;
    Project project;

    String namespace;
    String podName; // smallest unit of kubernetes
    String previewUrl; // application discovered when running pod

    PreviewStatus status;

    Instant startedAt;
    Instant terminatedAt;

    Instant createdAt;
}
