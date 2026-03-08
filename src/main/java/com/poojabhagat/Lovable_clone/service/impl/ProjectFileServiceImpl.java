package com.poojabhagat.Lovable_clone.service.impl;

import com.poojabhagat.Lovable_clone.dto.project.FileContentResponse;
import com.poojabhagat.Lovable_clone.dto.project.FileNode;
import com.poojabhagat.Lovable_clone.dto.project.FileTreeResponse;
import com.poojabhagat.Lovable_clone.entity.Project;
import com.poojabhagat.Lovable_clone.entity.ProjectFile;
import com.poojabhagat.Lovable_clone.error.ResourceNotFoundException;
import com.poojabhagat.Lovable_clone.mapper.ProjectFileMapper;
import com.poojabhagat.Lovable_clone.repository.ProjectFileRepository;
import com.poojabhagat.Lovable_clone.repository.ProjectRepository;
import com.poojabhagat.Lovable_clone.service.ProjectFileService;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectFileServiceImpl implements ProjectFileService {

    private final ProjectRepository projectRepository;
    private final ProjectFileRepository projectFileRepository;
    private final MinioClient minioClient;
    private final ProjectFileMapper projectFileMapper;

    @Value("${minio.project-bucket}")
    private String projectBucket;

    private static final String BUCKET_NAME = "projects";


    @Override
    public FileTreeResponse getFileTree(Long projectId) {
        List<ProjectFile> projectFileList = projectFileRepository.findByProjectId(projectId);
        List<FileNode> projectFilesNodes = projectFileMapper.toListOfFileNode(projectFileList);
        return new FileTreeResponse(projectFilesNodes);
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path) {
        String objectName = projectId + "/" + path;
        try (
                InputStream is = minioClient.getObject(
                        GetObjectArgs.builder()
                                .bucket(BUCKET_NAME)
                                .object(objectName)
                                .build())) {
            String content = new String(is.readAllBytes(), StandardCharsets.UTF_8); // since images can also be stored so
            return new FileContentResponse(path, content);
        } catch (Exception e) {
            log.error("Failed to read file: {}/{}", projectId, path, e);
            throw new RuntimeException("Failed to read file content", e);
        }
    }

    @Override
    public void saveFile(Long projectId, String path, String content) {
        Project project = projectRepository.findById(projectId).orElseThrow(
                () -> new ResourceNotFoundException("Project", projectId.toString())
        );

        String cleanPath = path.startsWith("/") ? path.substring(1) : path;
        String objectKey = projectId + "/" + cleanPath;

        try {
            byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
            InputStream inputStream = new ByteArrayInputStream(contentBytes);
            // Saving the file Content
            // Upload File to MinIO (Actual File Storage)
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(projectBucket)             // Specifies bucket name in MinIO
                            .object(objectKey)                 // File location inside bucket
                            .stream(inputStream, contentBytes.length ,-1)   // Uploads stream data
                            .contentType(determineContentType(path))
                            .build());

            // Saving the metadata in DB
            ProjectFile file = projectFileRepository.findByProjectIdAndPath(projectId, cleanPath)
                    .orElseGet(() -> ProjectFile.builder()
                            .project(project)
                            .path(cleanPath)
                            .minioObjectKey(objectKey)
                            .createdAt(Instant.now())
                            .build());
            file.setUpdatedAt(Instant.now());
            projectFileRepository.save(file);
            log.info("Saved file: {}", objectKey);
        } catch (Exception e) {
            log.error("Failed to save file {}/{}", projectId, cleanPath, e);
            throw new RuntimeException("File save failed", e);
        }
    }

    private String determineContentType(String path) {
        String type = URLConnection.guessContentTypeFromName(path);
        if (type != null) return type;
        if (path.endsWith(".jsx") || (path.endsWith(".ts")) || (path.endsWith(".tsx")) ) return "text/javascript";
        if (path.endsWith(".json")) return "application/json";
        if (path.endsWith(".css")) return "text/css";

        return "text/plain";
    }
}

/* This method saves file content in MinIO using streaming and stores only metadata in the database.
It validates the project, generates a unique object key, uploads the file, updates timestamps, and
ensures consistency with proper error handling. */

/* This code checks whether file metadata already exists for a given project and path. If it exists, we update it; otherwise,
we create new metadata. Metadata contains information about the file such as path, project reference, and storage key,
while actual file content is stored in MinIO. This separation improves scalability and performance. */

// MinIO -> Files exists & Postgres DB -> Metadata of File