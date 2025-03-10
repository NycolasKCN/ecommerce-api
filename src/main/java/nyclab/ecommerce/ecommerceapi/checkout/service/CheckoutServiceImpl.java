package nyclab.ecommerce.ecommerceapi.checkout.service;

import jakarta.transaction.Transactional;
import nyclab.ecommerce.ecommerceapi.address.domain.Address;
import nyclab.ecommerce.ecommerceapi.address.dto.AddressRequestData;
import nyclab.ecommerce.ecommerceapi.checkout.dto.PurchaseDTO;
import nyclab.ecommerce.ecommerceapi.checkout.dto.PurchaseResponse;
import nyclab.ecommerce.ecommerceapi.country.service.CountryService;
import nyclab.ecommerce.ecommerceapi.customer.domain.Customer;
import nyclab.ecommerce.ecommerceapi.customer.service.CustomerService;
import nyclab.ecommerce.ecommerceapi.order.domain.Order;
import nyclab.ecommerce.ecommerceapi.orderitem.domain.OrderItem;
import nyclab.ecommerce.ecommerceapi.orderitem.dto.OrderItemRequestData;
import nyclab.ecommerce.ecommerceapi.product.service.ProductService;
import nyclab.ecommerce.ecommerceapi.state.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.Supplier;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private final CustomerService customerService;
    private final ProductService productService;
    private final CountryService countryService;
    private final StateService stateService;

    @Autowired
    public CheckoutServiceImpl(
            CustomerService customerService,
            ProductService productService,
            CountryService countryService,
            StateService stateService
    ) {
        this.customerService = customerService;
        this.productService = productService;
        this.countryService = countryService;
        this.stateService = stateService;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(PurchaseDTO purchase) {
        Order order = purchase.getOrder().toEntity();
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        purchase.getOrderItems().forEach((data) -> {
            order.addOrderItem(orderItemFromRequestData(data));
        });

        order.setBillingAddress(mapAddressRequestToAddress(purchase::getBillingAddress));
        order.setShippingAddress(mapAddressRequestToAddress(purchase::getShippingAddress));

        Customer customer = customerService.getCustomerById(purchase.getCustomerId());
        customer.addOrder(order);

        customerService.saveCustomer(customer);

        return new PurchaseResponse(order.getOrderTrackingNumber());
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }

    private OrderItem orderItemFromRequestData(OrderItemRequestData orderItemRequestData) {
        OrderItem orderItem = orderItemRequestData.toEntity();
        orderItem.setProduct(productService.getProduct(orderItemRequestData.getProductId()));
        return orderItem;
    }

    private Address mapAddressRequestToAddress(Supplier<AddressRequestData> addressSupplier) {
        Address address = addressSupplier.get().toEntity();
        address.setCountry(countryService.getCountry(addressSupplier.get().getCountryId()));
        address.setState(stateService.getState(addressSupplier.get().getStateId()));
        return address;
    }

}
