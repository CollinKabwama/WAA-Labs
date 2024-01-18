package com.lab2.lab2.repo;

import com.lab2.lab2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
