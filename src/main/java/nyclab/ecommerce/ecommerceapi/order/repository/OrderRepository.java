package nyclab.ecommerce.ecommerceapi.order.repository;

import nyclab.ecommerce.ecommerceapi.order.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByCustomerEmailIgnoreCase(String email, Pageable pageable);
}
