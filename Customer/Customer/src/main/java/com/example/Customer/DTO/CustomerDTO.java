package com.example.Customer.DTO;

import com.example.Customer.Model.Product;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {

    private String name;

    private List<Product> products;

    private List<Integer> productIds;
}
