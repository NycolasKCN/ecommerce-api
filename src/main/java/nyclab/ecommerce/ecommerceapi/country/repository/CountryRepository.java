package nyclab.ecommerce.ecommerceapi.country.repository;

import nyclab.ecommerce.ecommerceapi.country.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
