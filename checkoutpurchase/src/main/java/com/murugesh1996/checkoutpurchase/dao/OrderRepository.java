package com.murugesh1996.checkoutpurchase.dao;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.murugesh1996.checkoutpurchase.entity.Order;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "${allowed.origins}")
@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {

	 Page<Order> findByCustomerEmailOrderByDateCreatedDesc(@Param("email") String email, Pageable pageable);
}
