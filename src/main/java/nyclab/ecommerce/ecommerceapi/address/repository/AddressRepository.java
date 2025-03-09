package nyclab.ecommerce.ecommerceapi.address.repository;

import nyclab.ecommerce.ecommerceapi.address.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
