package com.example.Product.Controller;

import com.example.Product.Entity.Product;
import com.example.Product.IProduct.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v2")
@RestController
public class ProductController {

    @Autowired
    private IProduct product;

    @PostMapping("/create/product")
    public ResponseEntity<List<Integer>> createProduct(@RequestBody List<Product> products){
        List<Integer> product1 = product.createProduct(products);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    @GetMapping("/get/product/{ids}")
    public ResponseEntity<List<Product>> getAllProduct(@PathVariable List<Integer> ids){
        List<Product> allProduct = product.getAllProduct(ids);
        return  new ResponseEntity<>(allProduct,HttpStatus.OK);
    }
}
