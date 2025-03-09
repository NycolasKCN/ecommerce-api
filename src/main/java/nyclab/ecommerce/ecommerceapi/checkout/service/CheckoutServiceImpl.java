package nyclab.ecommerce.ecommerceapi.checkout.service;

import jakarta.transaction.Transactional;
import nyclab.ecommerce.ecommerceapi.checkout.dto.PurchaseDTO;
import nyclab.ecommerce.ecommerceapi.checkout.dto.PurchaseResponse;
import nyclab.ecommerce.ecommerceapi.customer.domain.Customer;
import nyclab.ecommerce.ecommerceapi.customer.repository.CustomerRepository;
import nyclab.ecommerce.ecommerceapi.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(PurchaseDTO purchase) {
        Order order = purchase.getOrder();
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        purchase.getOrderItems().forEach(order::addOrderItem);

        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();
        customer.addOrder(order);

        customerRepository.save(customer);

        return new PurchaseResponse(order.getOrderTrackingNumber());
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
