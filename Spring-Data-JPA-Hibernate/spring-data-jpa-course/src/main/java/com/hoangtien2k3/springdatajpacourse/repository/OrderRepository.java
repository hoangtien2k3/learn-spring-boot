package com.hoangtien2k3.springdatajpacourse.repository;

import com.hoangtien2k3.springdatajpacourse.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderTrackingNumber(String orderTrackingNumber);
}
