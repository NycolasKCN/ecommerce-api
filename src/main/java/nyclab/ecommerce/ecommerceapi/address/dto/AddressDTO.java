package nyclab.ecommerce.ecommerceapi.address.dto;

import lombok.Builder;
import lombok.Data;
import nyclab.ecommerce.ecommerceapi.address.domain.Address;
import nyclab.ecommerce.ecommerceapi.country.dto.CountryDTO;
import nyclab.ecommerce.ecommerceapi.state.dto.StateDTO;

@Data
@Builder
public class AddressDTO {
    private Long id;
    private String city;
    private CountryDTO country;
    private StateDTO state;
    private String street;
    private String zipCode;

    public Address toEntity() {
        return Address.builder()
                .id(id)
                .city(city)
                .country(country.toEntity())
                .state(state.toEntity())
                .street(street)
                .zipCode(zipCode)
                .build();
    }
}
