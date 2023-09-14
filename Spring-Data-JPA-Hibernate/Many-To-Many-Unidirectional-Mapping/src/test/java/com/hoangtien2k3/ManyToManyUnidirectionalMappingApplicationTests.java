package com.hoangtien2k3;

import com.hoangtien2k3.entity.Role;
import com.hoangtien2k3.entity.User;
import com.hoangtien2k3.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
class ManyToManyUnidirectionalMappingApplicationTests {

	@Autowired
	private UserRepository userRepository;


	@Transactional
	@Test
	void saveUser() {
		User user = User.builder()
				.firstName("hoangtien2k3")
				.lastName("qx1")
				.email("hoangtien2k3qx1@gmail.com")
				.password("123456")
				.build();

		Role admin = Role.builder()
				.name("ROLE_ADMIN")
				.build();

		Role customer = Role.builder()
				.name("ROLE_CUSTOMER")
				.build();

		user.add(admin);
		user.add(customer);

		// Lưu đối tượng User vào cơ sở dữ liệu
		userRepository.save(user);
	}


	@Test
	void updateUser() {
		Optional<User> userOptional = userRepository.findById(1L);

		if (userOptional.isPresent()) {
			User user = userOptional.get();

			user.setFirstName("hoangtien2k3qx1");
			user.setEmail("hoangtien2k3qx1@gmail.com");

			Role roleUser = new Role();
			roleUser.setName("ROLE_USER");

			user.add(roleUser);

			userRepository.save(user);
		} else {
			// Handle the case when the user is not found, e.g., throw an exception or log an error.
		}
	}


	@Test
	void fetchUser(){
		User user = userRepository.findById(1L).get();
		System.out.println(user.getEmail());
		user.getRoles().forEach((r) -> {
			System.out.println(r.getName());
		});
	}

	@Test
	void deleteUser(){
		userRepository.deleteById(1L);
	}

	@Test
	void contextLoads() {
	}

}
