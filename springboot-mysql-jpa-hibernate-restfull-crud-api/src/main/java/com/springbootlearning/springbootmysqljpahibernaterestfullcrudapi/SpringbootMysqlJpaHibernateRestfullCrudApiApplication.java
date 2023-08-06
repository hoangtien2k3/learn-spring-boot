package com.springbootlearning.springbootmysqljpahibernaterestfullcrudapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbootMysqlJpaHibernateRestfullCrudApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMysqlJpaHibernateRestfullCrudApiApplication.class, args);
	}

}
