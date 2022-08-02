package com.murugesh1996.checkoutpurchase.dto;

import com.murugesh1996.checkoutpurchase.entity.Address;
import com.murugesh1996.checkoutpurchase.entity.Customer;
import com.murugesh1996.checkoutpurchase.entity.Order;
import com.murugesh1996.checkoutpurchase.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

	private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
