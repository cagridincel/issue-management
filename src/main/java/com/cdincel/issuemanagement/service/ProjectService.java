package com.cdincel.issuemanagement.service;

import com.cdincel.issuemanagement.entity.IssueHistory;
import com.cdincel.issuemanagement.entity.Project;
import com.cdincel.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    Project save(Project project);
    Project getById(Long Id);
    List<Project> getByProjectCode(String ProjectCode);
    List<Project> getByProjectCodeContains(String projectCode);
    Page<Project> getAllPageable (Pageable pageable);
    Boolean delete (Project project);
}
