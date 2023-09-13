package com.hoangtien2k3.OneToManyBidirectional;

import com.hoangtien2k3.OneToManyBidirectional.entity.Order;
import com.hoangtien2k3.OneToManyBidirectional.entity.OrderItem;
import com.hoangtien2k3.OneToManyBidirectional.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class OneToManyBidirectionalApplicationTests {

	@Autowired
	private OrderRepository orderRepository;

	@Test
	void testSaveOrder(){

		// create Order object
		Order order = new Order();

		OrderItem orderItem = new OrderItem();
		orderItem.setImageUrl("image_url.png");
		orderItem.setPrice(new BigDecimal(100));
		// add orderitem to order
		order.add(orderItem);

		OrderItem orderItem2 = new OrderItem();
		orderItem2.setImageUrl("image_url.png");
		orderItem2.setPrice(new BigDecimal(200));
		// add orderItem2 to order
		order.add(orderItem2);

		order.setOrderTrackingNumber("1000");
		order.setStatus("IN PROGRESS");
		// total amount of the order
		order.setTotalPrice(order.getTotalAmount());

		// Quantity of the order items
		order.setTotalQuantity(2);

		orderRepository.save(order);

	}

	@Test
	void testUpdateOrder(){
		Order order = orderRepository.findById(1L).get();
		order.setStatus("DELIVERED");
		orderRepository.save(order);
	}

	@Test
	void testGetAllOrders(){

		List<Order> orders = orderRepository.findAll();

		orders.forEach((o) -> {

			System.out.println("order id :: " + o.getId());

			o.getOrderItems().forEach((orderItem -> {
				System.out.println("orderItem :: " + orderItem.getId());
			}));
		});
	}

	@Test
	void testFindByOrderTrackingNumber(){

		Order order = orderRepository.findByOrderTrackingNumber("1000");

		// add fetch type as EAGER
//        order.getOrderItems().forEach((o) -> {
//            System.out.println(o.getId());
//        });

	}

	@Test
	void testDeleteOrder(){

		orderRepository.deleteById(1L);
	}

}
