package com.cdincel.issuemanagement.repository;

import com.cdincel.issuemanagement.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {
        }
