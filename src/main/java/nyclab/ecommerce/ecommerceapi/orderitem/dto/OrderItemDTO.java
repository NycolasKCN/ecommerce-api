package nyclab.ecommerce.ecommerceapi.orderitem.dto;

import lombok.Builder;
import lombok.Data;
import nyclab.ecommerce.ecommerceapi.order.dto.OrderDTO;

import java.math.BigDecimal;

@Data
@Builder
public class OrderItemDTO {
    private Long id;
    private String imageUrl;
    private BigDecimal unitPrice;
    private Integer quantity;
    private Long productId;
    private OrderDTO order;
}