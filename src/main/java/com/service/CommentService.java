package com.service;

import com.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Comment save(Comment comment);
    void delete(Long id);
    List<Comment> findByHome(Long id);
    Optional<Comment> findById(Long id);
}
