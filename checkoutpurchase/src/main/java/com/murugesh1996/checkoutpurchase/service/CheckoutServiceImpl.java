package com.murugesh1996.checkoutpurchase.service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murugesh1996.checkoutpurchase.dao.CustomerRepository;
import com.murugesh1996.checkoutpurchase.dto.Purchase;
import com.murugesh1996.checkoutpurchase.dto.PurchaseResponse;
import com.murugesh1996.checkoutpurchase.entity.Customer;
import com.murugesh1996.checkoutpurchase.entity.Order;
import com.murugesh1996.checkoutpurchase.entity.OrderItem;


@Service
public class CheckoutServiceImpl implements CheckoutService{

    @Autowired
	private CustomerRepository customerRepository;
	
	@Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Order order = purchase.getOrder();

        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();
        String theEmail = customer.getEmail();

        Customer customerFromDB = customerRepository.findByEmail(theEmail);
        if (customerFromDB != null) {
            customer = customerFromDB;
        }

        customer.add(order);
        customerRepository.save(customer);
        return new PurchaseResponse(orderTrackingNumber);
    }
	
	private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }

}
