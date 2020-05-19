package com.cdincel.issuemanagement.service.impl;

import com.cdincel.issuemanagement.entity.Issue;
import com.cdincel.issuemanagement.entity.IssueHistory;
import com.cdincel.issuemanagement.repository.IssueHistoryRepository;
import com.cdincel.issuemanagement.repository.IssueRepository;
import com.cdincel.issuemanagement.service.IssueHistoryService;
import com.cdincel.issuemanagement.service.IssueService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;
    private final ModelMapper modelMapper;

    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository, ModelMapper modelMapper) {
        this.issueHistoryRepository = issueHistoryRepository;
        this.modelMapper = modelMapper;
    }//inject ediyoruz const injection; final etiketi verince runtime da değişmesi engelleniyor. O nesne güvenli hale geliyor, bu şekilde injection tavsiye ediliyor

    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        if (issueHistory.getDate() == null) {
            throw new IllegalArgumentException("Issue cannot be null");
        }
       return issueHistoryRepository.save(issueHistory);
    }

    @Override
    public IssueHistory getById(Long Id) {
        return issueHistoryRepository.getOne(Id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
         issueHistoryRepository.delete(issueHistory);
         return Boolean.TRUE;
    }



}
