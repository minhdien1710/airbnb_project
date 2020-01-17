package com.airbnb_project.service;

import com.airbnb_project.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);
    List<User> findAll();
    Optional<User> findByUsername(String username);
}
