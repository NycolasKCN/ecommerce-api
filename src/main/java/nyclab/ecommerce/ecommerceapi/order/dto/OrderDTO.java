package nyclab.ecommerce.ecommerceapi.order.dto;

import lombok.Builder;
import lombok.Data;
import nyclab.ecommerce.ecommerceapi.address.dto.AddressDTO;
import nyclab.ecommerce.ecommerceapi.customer.dto.CustomerDTO;
import nyclab.ecommerce.ecommerceapi.order.domain.Order;
import nyclab.ecommerce.ecommerceapi.orderitem.dto.OrderItemDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class OrderDTO {
    private Long id;
    private String orderTrackingNumber;
    private Integer totalQuantity;
    private BigDecimal totalPrice;
    private String status;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
    private CustomerDTO customer;
    private AddressDTO shippingAddress;
    private AddressDTO billingAddress;
    private Set<OrderItemDTO> orderItems;

    public Order toEntity() {
        return Order.builder()
                .id(id)
                .orderTrackingNumber(orderTrackingNumber)
                .totalQuantity(totalQuantity)
                .totalPrice(totalPrice)
                .status(status)
                .dateCreated(dateCreated)
                .lastUpdated(lastUpdated)
                .customer(customer.toEntity())
                .shippingAddress(shippingAddress.toEntity())
                .billingAddress(billingAddress.toEntity())
                .build();
    }
}
