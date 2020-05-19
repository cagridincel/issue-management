package com.cdincel.issuemanagement.dto;

import com.cdincel.issuemanagement.entity.IssueStatus;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "Project Data Transfer Object")
public class IssueDto {
    private Long id;
    private String description;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserDto assignee;
    private ProjectDto project;
}
