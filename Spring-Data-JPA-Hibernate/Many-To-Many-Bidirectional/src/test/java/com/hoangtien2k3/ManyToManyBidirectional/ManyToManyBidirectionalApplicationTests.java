package com.hoangtien2k3.ManyToManyBidirectional;

import com.hoangtien2k3.ManyToManyBidirectional.entity.Role;
import com.hoangtien2k3.ManyToManyBidirectional.entity.User;
import com.hoangtien2k3.ManyToManyBidirectional.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ManyToManyBidirectionalApplicationTests {

	@Autowired
	private RoleRepository roleRepository;

	@Test
	void saveRole(){
		User user = new User();
		user.setFirstName("ramesh");
		user.setLastName("fadatare");
		user.setEmail("ramesh@gmail.com");
		user.setPassword("secrete");

		User admin = new User();
		admin.setFirstName("admin");
		admin.setLastName("admin");
		admin.setEmail("admin@gmail.com");
		admin.setPassword("admin");

		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");

		roleAdmin.getUsers().add(user);
		roleAdmin.getUsers().add(admin);

		user.getRoles().add(roleAdmin);
		admin.getRoles().add(roleAdmin);

		roleRepository.save(roleAdmin);
	}

	@Test
	void fetchRole(){
		List<Role> roles = roleRepository.findAll();
		roles.forEach((r) ->{
			System.out.println(r.getName());
			r.getUsers().forEach((u) ->{
				System.out.println(u.getFirstName());
			});
		});
	}

}
