package com.cdincel.issuemanagement.service;

import com.cdincel.issuemanagement.dto.ProjectDto;
import com.cdincel.issuemanagement.entity.IssueHistory;
import com.cdincel.issuemanagement.entity.Project;
import com.cdincel.issuemanagement.entity.User;
import com.cdincel.issuemanagement.util.Tpage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    ProjectDto save(ProjectDto project);
    ProjectDto getById(Long Id);
    Project getByProjectCode(String ProjectCode);
    List<Project> getByProjectCodeContains(String projectCode);
    Tpage<ProjectDto> getAllPageable (Pageable pageable);
    Boolean delete (Project project);
    ProjectDto update (Long id , ProjectDto project);
}
