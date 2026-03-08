package com.poojabhagat.Lovable_clone.controller;

import com.poojabhagat.Lovable_clone.dto.project.FileContentResponse;
import com.poojabhagat.Lovable_clone.dto.project.FileNode;
import com.poojabhagat.Lovable_clone.dto.project.FileTreeResponse;
import com.poojabhagat.Lovable_clone.service.ProjectFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/files")
public class FileController {
    private final ProjectFileService projectFileService;

    @GetMapping
    public ResponseEntity<FileTreeResponse> getFileTree(@PathVariable Long projectId) {
        return ResponseEntity.ok(projectFileService.getFileTree(projectId));
    }

    @GetMapping("/content") // /src/hooks/get-user-hook.jsx
    public ResponseEntity<FileContentResponse> getFile(
            @PathVariable Long projectId,
            @RequestParam String path
    ) {
        return ResponseEntity.ok(projectFileService.getFileContent(projectId, path));
    }
}
