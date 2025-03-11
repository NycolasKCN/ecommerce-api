package nyclab.ecommerce.ecommerceapi.orderitem.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderItemDTO {
    private Long id;
    private BigDecimal priceAtPurchase;
    private Integer quantity;
    private Long productId;
    private Long orderId;
}