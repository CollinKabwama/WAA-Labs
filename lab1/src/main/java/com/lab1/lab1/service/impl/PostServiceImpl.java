package com.lab1.lab1.service.impl;

import com.lab1.lab1.entity.Post;
import com.lab1.lab1.entity.dto.request.PostDto;
import com.lab1.lab1.repo.PostRepo;
import com.lab1.lab1.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Post> getAllPosts(String author) {
        return postRepo.getAllPosts(author);
    }

    @Override
    public Post getPostById(long postId) {
        Optional<Post> post = postRepo.getPostById(postId);
        if (post.isPresent()) {
            return post.get();
        }
        return null;
    }

    @Override
    public void createPost(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        postRepo.createPost(post);
    }

    @Override
    public void updatePostById(Long id, PostDto postDto) {
        postRepo.updatePostById(id, postDto);
    }

    @Override
    public void deletePostById(Long id) {
        postRepo.deletePostById(id);
    }
}
