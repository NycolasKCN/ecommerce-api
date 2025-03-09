package nyclab.ecommerce.ecommerceapi.state.dto;

import lombok.Builder;
import lombok.Data;
import nyclab.ecommerce.ecommerceapi.country.dto.CountryDTO;

@Data
@Builder
public class StateDTO {
    private int id;
    private String name;
    private CountryDTO country;
}
