package com.murugesh1996.checkoutpurchase.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murugesh1996.checkoutpurchase.dto.Purchase;
import com.murugesh1996.checkoutpurchase.dto.PurchaseResponse;
import com.murugesh1996.checkoutpurchase.service.CheckoutService;

@RestController
@RequestMapping("/${spring.application.name}/checkout")
public class CheckoutController {
	
	private CheckoutService checkoutService;
	
	public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

	@PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }

}
