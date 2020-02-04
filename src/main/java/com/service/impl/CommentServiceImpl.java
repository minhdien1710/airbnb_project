package com.service.impl;

import com.model.Comment;
import com.repository.CommentRepository;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> findByHome(Long id) {
        return commentRepository.findAllByHomeId(id);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }
}
