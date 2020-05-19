package com.cdincel.issuemanagement.service;

import com.cdincel.issuemanagement.dto.IssueDto;
import com.cdincel.issuemanagement.entity.Issue;
import com.cdincel.issuemanagement.entity.IssueHistory;
import com.cdincel.issuemanagement.util.Tpage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

   IssueDto save(IssueDto issue);
   IssueDto getById(Long Id);
   Tpage<IssueDto> getAllPageable (Pageable pageable);
   Boolean delete (Long issueId);
   IssueDto update(Long id, IssueDto issue);
}
