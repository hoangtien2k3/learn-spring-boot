package com.hoangtien2k3;

import com.hoangtien2k3.audit.AuditorAwareImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware") // được sử dụng để kích hoạt tính năng tự động gán thông tin về người thực hiện thao tác
public class SpringBootJpaAuditingMySqlExampleApplication {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaAuditingMySqlExampleApplication.class, args);
	}

}
