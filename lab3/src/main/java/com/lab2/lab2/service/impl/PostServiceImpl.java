package com.lab2.lab2.service.impl;

import com.lab2.lab2.entity.Post;
import com.lab2.lab2.entity.dto.request.PostDto;
import com.lab2.lab2.repo.PostRepo;
import com.lab2.lab2.service.PostService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Post> getAllPosts(String author) {
        return postRepo.findAll();
    }

    @Override
    public Post getPostById(long postId) {
        Optional<Post> post = postRepo.findById(postId);
        if (post.isPresent()) {
            return post.get();
        }
        return null;
    }

    @Override
    public void createPost(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        postRepo.save(post);
    }

    @Override
    public void updatePostById(Long id, PostDto postDto) {
        Optional<Post> postToUpdate = postRepo.findById(id);
        if (postToUpdate.isPresent()) {
            Post post = postToUpdate.get();
            post.setAuthor(postDto.getAuthor());
            post.setContent(postDto.getContent());
            post.setTitle(postDto.getTitle());
        }
    }

    @Override
    public void deletePostById(Long id) {
        Optional<Post> userToDelete = postRepo.findById(id);
        if (userToDelete.isPresent()) {
            postRepo.deleteById(id);
        }
    }
}


/*
public List<Post> getAllPosts(String author) {
        return author==null?posts: getAllPostsByAuthor(author);
    }

    public List<Post> getAllPostsByAuthor(String author) {
        return posts.stream()
                .filter(post -> post.getAuthor().toLowerCase().equals(author))
                .toList();
    }



    public Optional<Post> getPostById(long postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst();
    }
    public void createPost(Post post) {
        post.setId(Post.count++);
        posts.add(post);
    }

    @Override
    public void updatePostById(Long id, PostDto updatedPost) {
        Optional<Post> postToUpdate = getPostById(id);
        if (postToUpdate.isPresent()) {
            Post post = postToUpdate.get();
            post.setAuthor(updatedPost.getAuthor());
            post.setContent(updatedPost.getContent());
            post.setTitle(updatedPost.getTitle());
        }
    }

    @Override
    public void deletePostById(Long id) {
        Optional<Post> userToDelete = getPostById(id);
        if (userToDelete.isPresent()) {
            posts.remove(userToDelete.get());
        }
    }

    @Override
    public void run(String... args) throws Exception {
        posts = new ArrayList<>();
        posts.add(new Post(Post.count++, "Book 1", "Content of Book 1", "Author 1"));
        posts.add(new Post(Post.count++, "Book 2", "Content of Book 2", "Author 2"));
        posts.add(new Post(Post.count++, "Book 3", "Content of Book 3", "Author 3"));
        posts.add(new Post(Post.count++, "Book 4", "Content of Book 4", "Author 4"));
        posts.add(new Post(Post.count++, "Book 5", "Content of Book 5", "Author 5"));

    }

 */