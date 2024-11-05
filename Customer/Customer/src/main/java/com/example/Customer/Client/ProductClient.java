package com.example.Customer.Client;

import com.example.Customer.Model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product-service", url = "http://localhost:8087")
public interface ProductClient {

    @PostMapping("/api/v2/create/product")
    List<Integer> createProducts(@RequestBody List<Product> products);

    @GetMapping("/api/v2/get/product/{ids}")
    List<Product> getProductsByIds(@PathVariable("ids") List<Integer> productIds);
}
