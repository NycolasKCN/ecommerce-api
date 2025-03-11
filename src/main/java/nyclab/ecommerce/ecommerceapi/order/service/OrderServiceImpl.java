package nyclab.ecommerce.ecommerceapi.order.service;

import lombok.extern.slf4j.Slf4j;
import nyclab.ecommerce.ecommerceapi.order.domain.Order;
import nyclab.ecommerce.ecommerceapi.order.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Page<Order> findOrderByCustomerEmail(String email, Pageable pageable) {
        log.debug("findOrderByCustomerEmail called with email: {} page: {} pageSize: {}", email, pageable.getPageNumber(), pageable.getPageSize());
        var foundOrders = orderRepository.findByCustomerEmailIgnoreCase(email, pageable);
        log.debug("returning orders {} for email: {}", foundOrders.getTotalElements(), email);
        return foundOrders;
    }
}
