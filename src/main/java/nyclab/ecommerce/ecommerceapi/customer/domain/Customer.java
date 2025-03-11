package nyclab.ecommerce.ecommerceapi.customer.domain;

import jakarta.persistence.*;
import lombok.*;
import nyclab.ecommerce.ecommerceapi.customer.dto.CustomerDTO;
import nyclab.ecommerce.ecommerceapi.order.domain.Order;

import java.util.HashSet;
import java.util.Set;

// TODO: Improve JPA annotations to match the sql script

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();

    public void addOrder(Order order) {
        if (order != null) {
            if (this.orders == null) {
                this.orders = new HashSet<>();
            }
            this.orders.add(order);
            order.setCustomer(this);
        }
    }

    public CustomerDTO toDto() {
        return CustomerDTO.builder()
                .id(this.id)
                .firstName(this.firstName)
                .lastName(this.lastName)
                .email(this.email)
                .build();
    }
}
