package com.example.Customer.customerserviceImpl;

import com.example.Customer.Client.ProductClient;
import com.example.Customer.DTO.CustomerDTO;
import com.example.Customer.ICustomer.ICustomer;
import com.example.Customer.Model.Customer;
import com.example.Customer.Model.Product;
import com.example.Customer.Repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomer {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        List<Integer> products = productClient.createProducts(customerDTO.getProducts());
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setProductIds(products);
        Customer save = customerRepository.save(customer);
//        modelMapper.map(save,customerDTO.class);
        customerDTO.setName(save.getName());
        customerDTO.setProductIds(save.getProductIds());
        return customerDTO;
    }

    @Override
    public CustomerDTO getCustomerWithProducts(int customerId) {
        Optional<Customer> byId = customerRepository.findById(customerId);
        if (byId.isEmpty()) {
            return null;
        }

        List<Integer> collect = byId.stream()
                .map(p -> p.getProductIds())
                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<Product> products = productClient.getProductsByIds(collect);

        CustomerDTO customerDTO=new CustomerDTO();
        customerDTO.setName(byId.get().getName());
        customerDTO.setProducts(products);


        return customerDTO;
    }
}
