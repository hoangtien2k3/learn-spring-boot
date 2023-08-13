package com.hoangtien2k3.springboot;

import com.hoangtien2k3.springboot.model.Location;
import com.hoangtien2k3.springboot.model.User;
import com.hoangtien2k3.springboot.repository.LocationRepository;
import com.hoangtien2k3.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDtoTutorialsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDtoTutorialsApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void run(String... args) throws Exception {

		Location location = new Location();
		location.setPlace("Ha Noi");
		location.setDescription("Learn Spring Boot");
		location.setLongitude(40.5);
		location.setLatitude(30.6);
		locationRepository.save(location);

		User user1 = new User();
		user1.setFirstName("hoangtien2k3");
		user1.setLastName("qx1");
		user1.setEmail("hoangtien2k3qx1@gmail.com");
		user1.setPassword("123456");
		user1.setLocation(location);
		userRepository.save(user1);

		User user2 = new User();
		user2.setFirstName("taocay");
		user2.setLastName("github");
		user2.setEmail("taocaygithub@gmail.com");
		user2.setPassword("654321");
		user2.setLocation(location);
		userRepository.save(user2);

	}
}
