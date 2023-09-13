package com.hoangtien2k3.springdatajpacourse.repository;

import com.hoangtien2k3.springdatajpacourse.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}