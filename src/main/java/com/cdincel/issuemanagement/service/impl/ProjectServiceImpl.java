package com.cdincel.issuemanagement.service.impl;

import com.cdincel.issuemanagement.dto.ProjectDto;
import com.cdincel.issuemanagement.entity.Project;
import com.cdincel.issuemanagement.repository.ProjectRepository;
import com.cdincel.issuemanagement.service.ProjectService;
import com.cdincel.issuemanagement.util.Tpage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if (projectCheck!=null){
            throw new IllegalArgumentException("Project Code must be unique");
        }

        Project p = modelMapper.map(project, Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long Id) {
        Project p = projectRepository.getOne(Id);
        return modelMapper.map(p,ProjectDto.class);
    }

    @Override
    public Project getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return projectRepository.getByProjectCodeContains(projectCode);
    }

    @Override
    public Tpage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        Tpage<ProjectDto> response = new Tpage<ProjectDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return response;
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }

    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        Project projectdb = projectRepository.getOne(id);
        if (projectdb == null){
            throw new IllegalArgumentException("Project Doesnot exist id :" + id);
        }
        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(),id);
        if (projectCheck!=null){
            throw new IllegalArgumentException("Project Code must be unique");
        }
        projectdb.setProjectCode(project.getProjectCode());
        projectdb.setProjectName(project.getProjectName());
        projectRepository.save(projectdb);
        return modelMapper.map(projectdb,ProjectDto.class);
    }

}
