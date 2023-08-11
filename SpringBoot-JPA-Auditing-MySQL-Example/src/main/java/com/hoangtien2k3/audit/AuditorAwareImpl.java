package com.hoangtien2k3.audit;


import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

// AuditorAware: một interface được sử dụng để cung cấp thông tin về người tạo (creator) hoặc người cập nhật (updater) của một entity.
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        // Logic để trả về thông tin người tạo/cập nhật hiện tại
        // Ví dụ: đăng nhập của người dùng đang thao tác
        return Optional.of("tien2k3"); // trả về người tạo
    }
}

// ------------------ Use below code for spring security --------------------------

/*
class SpringSecurityAuditorAware implements AuditorAware<User> {

	public User getCurrentAuditor() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || !authentication.isAuthenticated()) {
			return null;
		}

		return ((MyUserDetails) authentication.getPrincipal()).getUser();
	}
}*/
