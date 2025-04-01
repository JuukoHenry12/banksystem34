package com.systemproject.systemproject.service;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import com.systemproject.systemproject.model.Product;


@Service
public class ProductService {

    List <Product> products = Arrays.asList(
        new Product(012,"Nike Shoes",145000),
        new Product(034,"water proof bag",50000)
    );
    
    public List<Product>getProduct(){
        return products;

    }
}
