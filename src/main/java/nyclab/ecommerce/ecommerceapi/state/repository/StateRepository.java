package nyclab.ecommerce.ecommerceapi.state.repository;

import nyclab.ecommerce.ecommerceapi.state.domain.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {
    Page<State> findByCountryCode(String countryCode, Pageable pageable);
}
