package com.lab2.lab2;

import com.lab2.lab2.entity.Post;
import com.lab2.lab2.entity.User;
import com.lab2.lab2.repo.PostRepo;
import com.lab2.lab2.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab2Application implements CommandLineRunner {
	@Autowired
	private PostRepo postRepo;

	@Autowired
	private UserRepo userRepo;
	public static void main(String[] args) {
		SpringApplication.run(Lab2Application.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		Post post1 = new Post("Book 1", "Content of Book 1", "Author 1");
		Post post2 = new Post("Book 2", "Content of Book 2", "Author 2");
		Post post3 = new Post("Book 3", "Content of Book 3", "Author 3");
		Post post4 = new Post("Book 4", "Content of Book 4", "Author 4");
		Post post5 = new Post( "Book 5", "Content of Book 5", "Author 5");


		User user1 = new User("User 1");
		User user2 = new User("User 2");
		User user3 = new User("User 3");
		user2.addPost(post1);
		user2.addPost(post3);
		user1.addPost(post2);
		user1.addPost(post4);
		user1.addPost(post5);

		userRepo.save(user1);
		userRepo.save(user2);
		userRepo.save(user3);


	}
}
