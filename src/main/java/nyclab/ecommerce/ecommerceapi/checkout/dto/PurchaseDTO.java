package nyclab.ecommerce.ecommerceapi.checkout.dto;

// TODO: implement validation

import lombok.Data;
import nyclab.ecommerce.ecommerceapi.address.dto.AddressRequestData;
import nyclab.ecommerce.ecommerceapi.order.dto.OrderRequestData;
import nyclab.ecommerce.ecommerceapi.orderitem.dto.OrderItemRequestData;

import java.util.Set;

@Data
public class PurchaseDTO {
    private Long customerId;
    private AddressRequestData shippingAddress;
    private AddressRequestData billingAddress;
    private OrderRequestData order;
    private Set<OrderItemRequestData> orderItems;
}
