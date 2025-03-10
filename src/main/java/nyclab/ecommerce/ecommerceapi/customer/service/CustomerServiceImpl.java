package nyclab.ecommerce.ecommerceapi.customer.service;

import nyclab.ecommerce.ecommerceapi.customer.domain.Customer;
import nyclab.ecommerce.ecommerceapi.customer.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // TODO: Create exceptions for not found objects
    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {

    }

    @Override
    public Page<Customer> getAllCustomers(Pageable pageable) {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }
}
