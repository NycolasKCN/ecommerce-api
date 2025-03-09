package nyclab.ecommerce.ecommerceapi.state.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import nyclab.ecommerce.ecommerceapi.country.domain.Country;
import nyclab.ecommerce.ecommerceapi.state.dto.StateDTO;

// TODO: Improve JPA annotations to match the sql script

@Entity
@Table(name = "state")
@Getter
@Setter
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

    public StateDTO toDTO() {
        return StateDTO.builder()
                .id(id)
                .name(name)
                .country(country.toDTO())
                .build();
    }
}
