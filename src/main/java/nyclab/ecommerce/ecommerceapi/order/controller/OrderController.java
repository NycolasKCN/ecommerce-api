package nyclab.ecommerce.ecommerceapi.order.controller;

import lombok.extern.slf4j.Slf4j;
import nyclab.ecommerce.ecommerceapi.order.domain.Order;
import nyclab.ecommerce.ecommerceapi.order.dto.OrderDTO;
import nyclab.ecommerce.ecommerceapi.order.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/orders")
@Slf4j
public class OrderController {
    private final OrderService orderSerivce;

    public OrderController(OrderService orderSerivce) {
        this.orderSerivce = orderSerivce;
    }

    @GetMapping("/search/findByCustomerEmail")
    public ResponseEntity<Page<OrderDTO>> findOrderByCustomerEmail(@RequestParam String email, Pageable pageable) {
        log.debug("findOrderByCustomerEmail called with email: {} page: {} pageSize: {}", email, pageable.getPageNumber(), pageable.getPageSize());

        return ResponseEntity.ok(orderSerivce.findOrderByCustomerEmail(email, pageable).map(Order::toDto));
    }
}
