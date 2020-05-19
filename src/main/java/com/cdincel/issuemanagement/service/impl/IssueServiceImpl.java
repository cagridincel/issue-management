package com.cdincel.issuemanagement.service.impl;

import com.cdincel.issuemanagement.dto.IssueDto;
import com.cdincel.issuemanagement.entity.Issue;
import com.cdincel.issuemanagement.entity.IssueHistory;
import com.cdincel.issuemanagement.repository.IssueRepository;
import com.cdincel.issuemanagement.service.IssueService;
import com.cdincel.issuemanagement.util.Tpage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;
    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }//inject ediyoruz const injection; final etiketi verince runtime da değişmesi engelleniyor. O nesne güvenli hale geliyor, bu şekilde injection tavsiye ediliyor

    @Override
    public IssueDto save(IssueDto issue) {
        if (issue.getDate() == null) {
            throw new IllegalArgumentException("IsseDate cannot be null");
        }
        Issue issuedb = modelMapper.map(issue,Issue.class);
        issuedb = issueRepository.save(issuedb);

        return  modelMapper.map(issuedb,IssueDto.class);

    }

    @Override
    public IssueDto getById(Long Id) {
        return modelMapper.map(issueRepository.getOne(Id),IssueDto.class);
    }

    @Override
    public Tpage<IssueDto> getAllPageable(Pageable pageable) {
       Page<Issue> data = issueRepository.findAll(pageable);
       Tpage page = new Tpage<IssueDto>();
       IssueDto[] dtos = modelMapper.map(data.getContent(),IssueDto[].class);
       page.setStat(data, Arrays.asList(dtos));
       return page;
    }

    @Override
    public Boolean delete(Long issueId) {
        issueRepository.deleteById(issueId);
        return true;
    }


    @Override
    public IssueDto update(Long id, IssueDto issue) {
        return null;
    }


}
