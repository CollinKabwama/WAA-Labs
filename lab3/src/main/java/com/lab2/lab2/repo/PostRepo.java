package com.lab2.lab2.repo;

import com.lab2.lab2.entity.Post;
import com.lab2.lab2.entity.dto.request.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepo extends JpaRepository<Post,Long> {
    List<Post> findPostsByTitle(String title);
}
