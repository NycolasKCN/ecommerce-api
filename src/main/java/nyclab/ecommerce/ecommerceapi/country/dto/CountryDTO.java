package nyclab.ecommerce.ecommerceapi.country.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryDTO {
    private int id;
    private String code;
    private String name;
}
