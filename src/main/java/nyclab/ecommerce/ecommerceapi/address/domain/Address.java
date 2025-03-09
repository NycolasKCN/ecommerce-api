package nyclab.ecommerce.ecommerceapi.address.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import nyclab.ecommerce.ecommerceapi.order.domain.Order;

// TODO: Improve JPA annotations to match the sql script

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "street")
    private String street;

    @Column(name = "zip_code")
    private String zip_code;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;
}
