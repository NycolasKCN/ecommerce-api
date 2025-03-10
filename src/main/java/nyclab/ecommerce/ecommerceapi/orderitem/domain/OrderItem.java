package nyclab.ecommerce.ecommerceapi.orderitem.domain;

import jakarta.persistence.*;
import lombok.*;
import nyclab.ecommerce.ecommerceapi.order.domain.Order;
import nyclab.ecommerce.ecommerceapi.product.domain.Product;

import java.math.BigDecimal;

// TODO: Improve JPA annotations to match the sql script

@Entity
@Table(name = "order_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "price_at_purchase")
    private BigDecimal priceAtPurchase;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

}
