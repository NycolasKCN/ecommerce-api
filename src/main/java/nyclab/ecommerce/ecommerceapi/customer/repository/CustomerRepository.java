package nyclab.ecommerce.ecommerceapi.customer.repository;

import nyclab.ecommerce.ecommerceapi.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
