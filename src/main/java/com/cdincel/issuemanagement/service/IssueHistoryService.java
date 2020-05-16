package com.cdincel.issuemanagement.service;

import com.cdincel.issuemanagement.entity.Issue;
import com.cdincel.issuemanagement.entity.IssueHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {
    IssueHistory save(IssueHistory issue);
    IssueHistory getById(Long Id);
    Page<IssueHistory> getAllPageable (Pageable pageable);
    Boolean delete (IssueHistory issueHistory);
}
