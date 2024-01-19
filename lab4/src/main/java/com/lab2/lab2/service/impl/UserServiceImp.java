package com.lab2.lab2.service.impl;

import com.lab2.lab2.entity.Comment;
import com.lab2.lab2.entity.Post;
import com.lab2.lab2.entity.User;
import com.lab2.lab2.entity.dto.request.CommentDto;
import com.lab2.lab2.entity.dto.request.PostDto;
import com.lab2.lab2.entity.dto.request.UserDto;
import com.lab2.lab2.repo.CommentRepo;
import com.lab2.lab2.repo.PostRepo;
import com.lab2.lab2.repo.UserRepo;
import com.lab2.lab2.service.CommentService;
import com.lab2.lab2.service.PostService;
import com.lab2.lab2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public List<Post> getUserPosts(Long userId) {
        User user = getUserById(userId);
        if (user != null) {
            return user.getPosts();
        }
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
        Optional<User> userToDelete = userRepo.findById(id);
        if (userToDelete.isPresent()) {
            userRepo.deleteById(id);
        }
    }

    @Override
    public Comment getCommentByUserPostComment(Long userId, Long postId, Long commentId) {
        User user = getUserById(userId);
        if (user!=null){
            Post post = postService.getPostById(postId);
            if (post!=null && user.getPosts().contains(post)){
                Comment comment = commentService.getCommentById(postId);
                if (comment!=null && post.getComments().contains(comment)){
                    return comment;
                }
            }
        }
        return null;
    }

    @Override
    public Post getPostByUser(Long userId, Long postId) {
        User user = getUserById(userId);
        if (user!=null){
            Post post = postService.getPostById(postId);
            if (post!=null && user.getPosts().contains(post)){
                return post;
            }
        }
        return null;
    }

    @Override
    public void createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepo.save(user);
    }

}
