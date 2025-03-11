package nyclab.ecommerce.ecommerceapi.state.dto;

import lombok.Builder;
import lombok.Data;
import nyclab.ecommerce.ecommerceapi.country.dto.CountryDTO;
import nyclab.ecommerce.ecommerceapi.state.domain.State;

@Data
@Builder
public class StateDTO {
    private int id;
    private String name;
    private CountryDTO country;

    public State toEntity() {
        return State.builder()
                .id(id)
                .name(name)
                .country(country.toEntity())
                .build();
    }
}
