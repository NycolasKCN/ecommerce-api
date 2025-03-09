package nyclab.ecommerce.ecommerceapi.checkout.service;

import nyclab.ecommerce.ecommerceapi.checkout.dto.PurchaseDTO;
import nyclab.ecommerce.ecommerceapi.checkout.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(PurchaseDTO purchase);
}
