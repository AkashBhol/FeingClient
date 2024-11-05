package com.example.Customer.ICustomer;

import com.example.Customer.DTO.CustomerDTO;

public interface ICustomer {

    public CustomerDTO createCustomer(CustomerDTO customerDTO);

    public CustomerDTO getCustomerWithProducts(int customerId);
}
