package nyclab.ecommerce.ecommerceapi.customer.dto;

import lombok.Builder;
import lombok.Data;
import nyclab.ecommerce.ecommerceapi.customer.domain.Customer;

@Data
@Builder
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public Customer toEntity() {
        return Customer.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .build();
    }
}
