package com.controller;

import com.message.response.ResponseMessage;
import com.model.Comment;
import com.model.Home;
import com.model.User;
import com.service.CommentService;
import com.service.HomeService;
import com.service.UserService;
import com.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth/api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @Autowired
    private HomeService homeService;

    private UserPrincipal getCurrentUser(){
        return (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    @GetMapping("/{homeId}")
    public ResponseEntity<?> listComment(@PathVariable Long homeId){
        List<Comment> comments = commentService.findByHome(homeId);
        if(comments.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(comments,HttpStatus.OK);
    }
    @PostMapping("/{homeId}")
    public ResponseEntity<ResponseMessage> createComment(@RequestBody Comment comment, @PathVariable Long homeId){
        if(comment.getContent()== null || comment.getContent().equals("")){
            return new ResponseEntity<>(new ResponseMessage("You have not comment yet"), HttpStatus.NO_CONTENT);
        }
        Optional<User> user = userService.findById(getCurrentUser().getId());
        comment.setUser(user.get());
        Optional<Home> home = homeService.findById(homeId);
        comment.setHome(home.get());
        commentService.save(comment);
        return new ResponseEntity<>(new ResponseMessage(comment.toString()),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id){
        Optional<Comment> comment = commentService.findById(id);
        if (comment.isPresent()){
            commentService.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Long id,@RequestBody Comment comment){
        Optional<Comment> comment1 = commentService.findById(id);
        if(comment1.isPresent()){
            comment1.get().setContent(comment.getContent());
            commentService.save(comment1.get());
            return new ResponseEntity<>(comment1.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


}}
