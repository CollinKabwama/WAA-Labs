package com.lab2.lab2.service.impl;

import com.lab2.lab2.entity.Comment;
import com.lab2.lab2.repo.CommentRepo;
import com.lab2.lab2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;
    public Comment getCommentById(long commentId) {
        Optional<Comment> comment = commentRepo.findById(commentId);
        if (comment.isPresent()) {
            return comment.get();
        }
        return null;
    }
}
