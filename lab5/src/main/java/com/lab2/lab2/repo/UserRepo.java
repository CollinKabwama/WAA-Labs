package com.lab2.lab2.repo;

import com.lab2.lab2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {
    @Query("select u from User u where size(u.posts) > :num ")
    List<User> usersWithMoreThanPosts(int num);

    @Query("select u from User u JOIN u.posts p where p.title = :title")
    List<User> usersThatMadePostWith(String title);

    User findByEmail(String email);


}
