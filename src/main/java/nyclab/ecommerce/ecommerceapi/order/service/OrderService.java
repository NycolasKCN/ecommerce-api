package nyclab.ecommerce.ecommerceapi.order.service;

import nyclab.ecommerce.ecommerceapi.order.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    Page<Order> findOrderByCustomerEmail(String email, Pageable pageable);
}
