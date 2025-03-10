package nyclab.ecommerce.ecommerceapi.orderitem.dto;

import lombok.Data;
import nyclab.ecommerce.ecommerceapi.orderitem.domain.OrderItem;

import java.math.BigDecimal;

@Data
public class OrderItemRequestData {
    private Long productId;
    private Integer quantity;
    private BigDecimal priceAtPurchase;

    public OrderItem toEntity() {
        return OrderItem.builder()
                .quantity(quantity)
                .priceAtPurchase(priceAtPurchase)
                .build();
    }
}
