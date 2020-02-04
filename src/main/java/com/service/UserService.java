package com.service;

import com.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);
    List<User> findAll();
    void delete(Long id);
    Optional<User> findById(Long id);
}
