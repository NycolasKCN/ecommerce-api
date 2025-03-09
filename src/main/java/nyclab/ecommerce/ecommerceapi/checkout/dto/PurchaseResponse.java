package nyclab.ecommerce.ecommerceapi.checkout.dto;

import lombok.Data;

@Data
public class PurchaseResponse {
    private final String orderTrackingNumber;
}
