package com.example.Product.IProduct;

import com.example.Product.Entity.Product;

import java.util.List;

public interface IProduct {

    public List<Integer> createProduct(List<Product> product);

    public List<Product> getAllProduct( List<Integer> ids);
}
