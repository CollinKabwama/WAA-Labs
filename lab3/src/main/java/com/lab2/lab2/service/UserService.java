package com.lab2.lab2.service;

import com.lab2.lab2.entity.Post;
import com.lab2.lab2.entity.User;
import com.lab2.lab2.entity.dto.request.UserDto;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();


    User getUserById(Long id);

    void createUser(UserDto userDto);

    List<Post> getUserPosts(Long id);

    void deleteUserById(Long id);
}
