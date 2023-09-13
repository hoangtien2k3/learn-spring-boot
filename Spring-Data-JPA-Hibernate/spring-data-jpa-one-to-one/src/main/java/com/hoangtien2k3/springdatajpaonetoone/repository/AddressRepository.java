package com.hoangtien2k3.springdatajpaonetoone.repository;

import com.hoangtien2k3.springdatajpaonetoone.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}