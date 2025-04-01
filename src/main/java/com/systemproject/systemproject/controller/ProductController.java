package com.systemproject.systemproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.systemproject.systemproject.model.Product;
import com.systemproject.systemproject.service.ProductService;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    public List<Product>getProduct(){
        return service.getProduct();
    }
    
}
