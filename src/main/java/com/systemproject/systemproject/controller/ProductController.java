package com.systemproject.systemproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.systemproject.systemproject.model.Product;
import com.systemproject.systemproject.service.ProductService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService service;
     
    @GetMapping("/products")
    public List<Product>getProduct(){
        return service.getProduct();
    }

    @GetMapping("/product/{productId}")
    public Product getProductById(@PathVariable("productId") int productId){
        return service.getProductById(productId);
    }

    @PostMapping("/addproduct")
    public void addProduct(Product product){
        service.addProduct(product);
    }
    

    //update product
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product){
        service.updateProduct(product);
    }
       
     // delete products
    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable("prodId") int prodId){
        service.deleteProduct(prodId);
    }
}
