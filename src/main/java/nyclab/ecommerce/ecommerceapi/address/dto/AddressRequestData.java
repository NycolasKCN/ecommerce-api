package nyclab.ecommerce.ecommerceapi.address.dto;

import lombok.Data;
import nyclab.ecommerce.ecommerceapi.address.domain.Address;

@Data
public class AddressRequestData {
    private String city;
    private Integer countryId;
    private Integer stateId;
    private String street;
    private String zipCode;

    public Address toEntity() {
        return Address.builder()
                .city(city)
                .street(street)
                .zipCode(zipCode)
                .build();
    }
}
