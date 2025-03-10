package nyclab.ecommerce.ecommerceapi.order.dto;

import lombok.Data;
import nyclab.ecommerce.ecommerceapi.order.domain.Order;

import java.math.BigDecimal;

@Data
public class OrderRequestData {
    private BigDecimal totalPrice;
    private Integer totalQuantity;

    public Order toEntity() {
        return Order.builder()
                .totalPrice(totalPrice)
                .totalQuantity(totalQuantity)
                .build();
    }
}
