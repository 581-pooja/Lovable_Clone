package com.poojabhagat.Lovable_clone.mapper;

import com.poojabhagat.Lovable_clone.dto.project.FileNode;
import com.poojabhagat.Lovable_clone.entity.ProjectFile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectFileMapper {

    List<FileNode> toListOfFileNode(List<ProjectFile> projectFileList);

}
