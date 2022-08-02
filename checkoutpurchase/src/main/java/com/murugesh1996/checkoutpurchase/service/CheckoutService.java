package com.murugesh1996.checkoutpurchase.service;

import com.murugesh1996.checkoutpurchase.dto.Purchase;
import com.murugesh1996.checkoutpurchase.dto.PurchaseResponse;

public interface CheckoutService {
	PurchaseResponse placeOrder(Purchase purchase);
}
