package com.poojabhagat.Lovable_clone.service;

import com.poojabhagat.Lovable_clone.dto.project.FileContentResponse;
import com.poojabhagat.Lovable_clone.dto.project.FileTreeResponse;

public interface ProjectFileService {
    FileTreeResponse getFileTree(Long projectId);

    FileContentResponse getFileContent(Long projectId, String path);

    void saveFile(Long projectId, String filePath, String fileContent);
}
