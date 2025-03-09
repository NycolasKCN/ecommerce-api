package nyclab.ecommerce.ecommerceapi.address.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {
    private Long id;
    private String city;
    private String country;
    private String state;
    private String street;
    private String zipCode;
}
