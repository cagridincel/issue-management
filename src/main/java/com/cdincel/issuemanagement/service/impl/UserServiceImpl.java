package com.cdincel.issuemanagement.service.impl;

import com.cdincel.issuemanagement.entity.IssueHistory;
import com.cdincel.issuemanagement.entity.User;
import com.cdincel.issuemanagement.repository.UserRepository;
import com.cdincel.issuemanagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (user.getEmail() == null) {
            throw new IllegalArgumentException("User mail cannot be null");
        }
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User getById(Long Id) {
        return userRepository.getOne(Id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
