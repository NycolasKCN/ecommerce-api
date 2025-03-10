package nyclab.ecommerce.ecommerceapi.order.domain;

import jakarta.persistence.*;
import lombok.*;
import nyclab.ecommerce.ecommerceapi.address.domain.Address;
import nyclab.ecommerce.ecommerceapi.customer.domain.Customer;
import nyclab.ecommerce.ecommerceapi.orderitem.domain.OrderItem;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

// TODO: Improve JPA annotations to match the sql script

@Entity
@Table(name = "orders")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "status")
    private String status;

    @Column(name = "date_created")
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id", nullable = false)
    private Address shippingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id", referencedColumnName = "id", nullable = false)
    private Address billingAddress;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<>();

    public void addOrderItem(OrderItem order) {
        if (order != null) {
            if (orderItems == null) {
                orderItems = new HashSet<>();
            }
            this.orderItems.add(order);
            order.setOrder(this);
        }
    }

}
