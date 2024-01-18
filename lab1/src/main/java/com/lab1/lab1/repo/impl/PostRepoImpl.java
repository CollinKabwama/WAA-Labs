package com.lab1.lab1.repo.impl;

import com.lab1.lab1.entity.Post;
import com.lab1.lab1.entity.dto.request.PostDto;
import com.lab1.lab1.repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo,CommandLineRunner {

    @Autowired
    private ModelMapper modelMapper;

    List<Post> posts;


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

}
