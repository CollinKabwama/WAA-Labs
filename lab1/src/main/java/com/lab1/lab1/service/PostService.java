package com.lab1.lab1.service;

import com.lab1.lab1.entity.Post;
import com.lab1.lab1.entity.dto.request.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts(String author);

    Post getPostById(long postId);

    void createPost(PostDto postDto);

    void updatePostById(Long id, PostDto postDto);

    void deletePostById(Long id);
}
