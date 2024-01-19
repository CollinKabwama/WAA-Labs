package com.lab2.lab2.service;

import com.lab2.lab2.entity.Post;
import com.lab2.lab2.entity.dto.request.CommentDto;
import com.lab2.lab2.entity.dto.request.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts(String author);

    Post getPostById(long postId);

    void createPost(PostDto postDto);

    void updatePostById(Long id, PostDto postDto);

    void deletePostById(Long id);

    void createComment(CommentDto commentDto, Long id);
}
