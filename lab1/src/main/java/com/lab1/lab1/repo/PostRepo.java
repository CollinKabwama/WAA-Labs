package com.lab1.lab1.repo;

import com.lab1.lab1.entity.Post;
import com.lab1.lab1.entity.dto.request.PostDto;

import java.util.List;
import java.util.Optional;

public interface PostRepo {
    List<Post> getAllPosts(String author);
    public Optional<Post> getPostById(long postId);
    public void createPost(Post post);

    void updatePostById(Long id, PostDto postDto);

    void deletePostById(Long id);
}
