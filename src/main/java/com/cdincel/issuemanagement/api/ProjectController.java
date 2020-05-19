package com.cdincel.issuemanagement.api;

import com.cdincel.issuemanagement.dto.ProjectDto;
import com.cdincel.issuemanagement.service.ProjectService;
import com.cdincel.issuemanagement.service.impl.ProjectServiceImpl;
import com.cdincel.issuemanagement.util.ApiPaths;
import com.cdincel.issuemanagement.util.Tpage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value = ApiPaths.ProjectCtrl.CTRL, description = "Project APIs")
@Slf4j
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get by Id Operation",response = ProjectDto.class)
    public ResponseEntity<Tpage<ProjectDto>> getAllByPagination(Pageable pageable) {
        Tpage<ProjectDto> data = projectServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get by Id Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id) {
        log.info("ProjectController -> GetbyID -> param" + id);
        log.debug("ProjectController -> GetbyID -> param" + id);
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }
    @PostMapping
    @ApiOperation(value = "Create Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project){// dto içinde ki notnull annotationının çalışması için @Valid koyuyoruz.
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }
    //@RequestMapping(path = "/update",method = RequestMethod.PUT)
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long id, @Valid @RequestBody ProjectDto project){
        return ResponseEntity.ok(projectServiceImpl.update(id,project));
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation",response = Boolean.class)
    public  ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }
}

