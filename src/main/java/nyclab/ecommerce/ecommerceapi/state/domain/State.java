package nyclab.ecommerce.ecommerceapi.state.domain;

import jakarta.persistence.*;
import lombok.*;
import nyclab.ecommerce.ecommerceapi.address.domain.Address;
import nyclab.ecommerce.ecommerceapi.country.domain.Country;
import nyclab.ecommerce.ecommerceapi.state.dto.StateDTO;

import java.util.ArrayList;
import java.util.List;

// TODO: Improve JPA annotations to match the sql script

@Entity
@Table(name = "state")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = {"name", "country"})
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "state")
    private List<Address> addresses = new ArrayList<>();

    public StateDTO toDto() {
        return StateDTO.builder()
                .id(id)
                .name(name)
                .country(country.toDto())
                .build();
    }
}
