package com.hoangtien2k3.OneToManyBidirectional.repository;

import com.hoangtien2k3.OneToManyBidirectional.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderTrackingNumber(String orderTrackingNumber);
}
