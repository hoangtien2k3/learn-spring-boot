package com.hoangtien2k3.ManyToManyBidirectional.repository;

import com.hoangtien2k3.ManyToManyBidirectional.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}