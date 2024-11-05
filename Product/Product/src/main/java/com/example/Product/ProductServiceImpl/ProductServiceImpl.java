package com.example.Product.ProductServiceImpl;

import com.example.Product.Entity.Product;
import com.example.Product.IProduct.IProduct;
import com.example.Product.ProductRepo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProduct {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Integer> createProduct(List<Product> product) {
        List<Product> products = productRepository.saveAll(product);
        List<Integer> collect = products.stream().map(p -> p.getId()).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<Product> getAllProduct(List<Integer> ids) {
        List<Product> byIdIn = productRepository.findByIdIn(ids);
        return byIdIn;
    }
}
