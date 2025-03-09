package nyclab.ecommerce.ecommerceapi.orderitem.repository;

import nyclab.ecommerce.ecommerceapi.orderitem.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
