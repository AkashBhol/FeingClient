package com.example.Customer.CustomerController;

import com.example.Customer.DTO.CustomerDTO;
import com.example.Customer.ICustomer.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v4")
@RestController
public class CustomerController {

  @Autowired
  private ICustomer customer;

    @PostMapping("/post/customer")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO customer1 = customer.createCustomer(customerDTO);
        return new ResponseEntity<>(customer1, HttpStatus.CREATED);
    }

    @GetMapping("/get/customer")
    public ResponseEntity<CustomerDTO> getSingleCustomer(@RequestParam("id") int id){
        CustomerDTO customerWithProducts = customer.getCustomerWithProducts(id);
        return new ResponseEntity<>(customerWithProducts,HttpStatus.OK);
    }
}
