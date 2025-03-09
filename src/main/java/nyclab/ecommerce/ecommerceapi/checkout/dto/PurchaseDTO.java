package nyclab.ecommerce.ecommerceapi.checkout.dto;

// TODO: implement

import lombok.Data;
import nyclab.ecommerce.ecommerceapi.address.domain.Address;
import nyclab.ecommerce.ecommerceapi.customer.domain.Customer;
import nyclab.ecommerce.ecommerceapi.order.domain.Order;
import nyclab.ecommerce.ecommerceapi.orderitem.domain.OrderItem;

import java.util.Set;

@Data
public class PurchaseDTO {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
