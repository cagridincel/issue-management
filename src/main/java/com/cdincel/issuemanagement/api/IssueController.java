package com.cdincel.issuemanagement.api;

import com.cdincel.issuemanagement.dto.IssueDto;
import com.cdincel.issuemanagement.service.impl.IssueServiceImpl;
import com.cdincel.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

    private final IssueServiceImpl issueServiceImpl;
    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable("id") Long id) {
        IssueDto issueDto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(issueDto);
    }
    @PostMapping
    public ResponseEntity<IssueDto> createIssue(@Valid @RequestBody IssueDto issue){// dto içinde ki notnull annotationının çalışması için @Valid koyuyoruz.
        return ResponseEntity.ok(issueServiceImpl.save(issue));
    }
    //@RequestMapping(path = "/update",method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateIssue(@PathVariable("id") Long id, @Valid @RequestBody IssueDto issue){
        return ResponseEntity.ok(issueServiceImpl.update(id,issue));
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }
}
