package nyclab.ecommerce.ecommerceapi.checkout.controller;

import nyclab.ecommerce.ecommerceapi.checkout.dto.PurchaseDTO;
import nyclab.ecommerce.ecommerceapi.checkout.dto.PurchaseResponse;
import nyclab.ecommerce.ecommerceapi.checkout.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/checkout")
public class CheckoutController {
    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody PurchaseDTO purchase) {
        return checkoutService.placeOrder(purchase);
    }
}
