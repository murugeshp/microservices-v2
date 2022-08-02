package com.murugesh1996.checkoutpurchase.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murugesh1996.checkoutpurchase.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

    Customer findByEmail(String theEmail);

}
