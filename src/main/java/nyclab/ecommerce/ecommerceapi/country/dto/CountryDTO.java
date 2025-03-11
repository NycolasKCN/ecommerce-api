package nyclab.ecommerce.ecommerceapi.country.dto;

import lombok.Builder;
import lombok.Data;
import nyclab.ecommerce.ecommerceapi.country.domain.Country;

@Data
@Builder
public class CountryDTO {
    private int id;
    private String code;
    private String name;

    public CountryDTO toDto() {
        return CountryDTO.builder()
                .id(id)
                .code(code)
                .name(name)
                .build();
    }

    public Country toEntity() {
        return Country.builder()
                .id(id)
                .code(code)
                .name(name)
                .build();
    }
}
