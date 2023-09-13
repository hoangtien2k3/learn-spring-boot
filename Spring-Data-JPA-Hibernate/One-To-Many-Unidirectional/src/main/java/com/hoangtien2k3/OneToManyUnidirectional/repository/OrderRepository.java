package com.hoangtien2k3.OneToManyUnidirectional.repository;

import com.hoangtien2k3.OneToManyUnidirectional.entiry.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderTrackingNumber(String orderTrackingNumber);
}