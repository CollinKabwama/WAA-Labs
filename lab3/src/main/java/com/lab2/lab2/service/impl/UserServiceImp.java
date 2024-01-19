package com.lab2.lab2.service.impl;

import com.lab2.lab2.entity.Post;
import com.lab2.lab2.entity.User;
import com.lab2.lab2.entity.dto.request.CommentDto;
import com.lab2.lab2.entity.dto.request.PostDto;
import com.lab2.lab2.entity.dto.request.UserDto;
import com.lab2.lab2.repo.PostRepo;
import com.lab2.lab2.repo.UserRepo;
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
    public void createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepo.save(user);
    }
}
