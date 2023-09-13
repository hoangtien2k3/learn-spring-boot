package com.hoangtien2k3.springdatajpaonetoone;

import com.hoangtien2k3.springdatajpaonetoone.entity.Address;
import com.hoangtien2k3.springdatajpaonetoone.entity.Order;
import com.hoangtien2k3.springdatajpaonetoone.repository.AddressRepository;
import com.hoangtien2k3.springdatajpaonetoone.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class SpringDataJpaOneToOneApplicationTests {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Test
	void saveOrderOperation(){
		// create Order object
		Order order = new Order();

		order.setOrderTrackingNumber("1000");
		order.setStatus("COMPLETED");
		order.setTotalPrice(new BigDecimal(2000));
		order.setTotalQuantity(5);

		Address billingAddress = new Address();
		billingAddress.setStreet("thanhxuan");
		billingAddress.setCity("hanoi");
		billingAddress.setState("running");
		billingAddress.setCountry("VietNam");
		billingAddress.setZipCode("11048");

		order.setBillingAddress(billingAddress);
		billingAddress.setOrder(order);
		// save both order and address ( Cascade type - ALL)
		orderRepository.save(order);
	}

	@Test
	void fetchBillingAddressOperation(){
		// display Order information

		// fetching address will also fetch associated order details
		Address address = addressRepository.findById(1L).get();

		System.out.println(address);
	}

	@Test
	void updateAddressOperation(){
		// fetch order with it's address
		Address address = addressRepository.findById(1L).get();
		address.setZipCode("11047");

		address.getOrder().setStatus("DELIVERED");

		// update address along with it's order
		addressRepository.save(address);
	}

	@Test
	void deleteOrderOperation(){
		// remove address will also remove oder
		addressRepository.deleteById(1L);
	}

}
