package nyclab.ecommerce.ecommerceapi.country.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import nyclab.ecommerce.ecommerceapi.country.dto.CountryDTO;
import nyclab.ecommerce.ecommerceapi.state.domain.State;

import java.util.List;

// TODO: Improve JPA annotations to match the sql script

@Entity
@Table(name = "country")
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "country")
    private List<State> states;

    public CountryDTO toDTO() {
        return CountryDTO.builder()
                .id(this.id)
                .code(this.code)
                .name(this.name)
                .build();
    }
}
