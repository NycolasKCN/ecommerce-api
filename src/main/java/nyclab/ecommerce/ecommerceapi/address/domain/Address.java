package nyclab.ecommerce.ecommerceapi.address.domain;

import jakarta.persistence.*;
import lombok.*;
import nyclab.ecommerce.ecommerceapi.address.dto.AddressDTO;
import nyclab.ecommerce.ecommerceapi.country.domain.Country;
import nyclab.ecommerce.ecommerceapi.order.domain.Order;
import nyclab.ecommerce.ecommerceapi.state.domain.State;

// TODO: Improve JPA annotations to match the sql script

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "zip_code")
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    private State state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;

    public AddressDTO toDto() {
        return AddressDTO.builder()
                .id(id)
                .city(city)
                .street(street)
                .zipCode(zipCode)
                .state(state.toDto())
                .country(country.toDto())
                .build();
    }
}
