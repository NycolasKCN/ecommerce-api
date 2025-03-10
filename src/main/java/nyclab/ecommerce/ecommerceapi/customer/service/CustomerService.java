package nyclab.ecommerce.ecommerceapi.customer.service;

import nyclab.ecommerce.ecommerceapi.customer.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Customer getCustomerById(Long id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Long id);

    Page<Customer> getAllCustomers(Pageable pageable);

    Customer updateCustomer(Customer customer);
}
