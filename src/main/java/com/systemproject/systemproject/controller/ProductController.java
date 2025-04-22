package com.systemproject.systemproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.systemproject.systemproject.model.Product;
import com.systemproject.systemproject.service.ProductService;

import java.io.IOException;
import java.util.List;


@RestController
public class ProductController {
  
   @Autowired 
   private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return  new ResponseEntity<>(service.getProduct(),HttpStatus.OK);
    }

    @GetMapping("/products/{prodId}")
    public ResponseEntity<Product >getProduct(@PathVariable int id) {

        Product product = service.getProduct(id);

        if(product !=null){
            return new ResponseEntity<>(product,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   
    @PostMapping("/addproduct")
    public ResponseEntity<?>addProduct(@RequestPart Product product,@RequestPart MultipartFile imageFile){
        try{
            Product product1 = service.addProduct(product,imageFile);
            return new ResponseEntity<>(product1,HttpStatus.CREATED);
        }catch(Exception e){

            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
        Product product = service.getProduct(productId);
        byte[] imageFile=product.getImageData();
        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(
            imageFile
        );
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id,@RequestPart Product product,@RequestPart MultipartFile imageFile){
     
        Product product1 =null;
        try{
             product1 =service.updateProduct(id,product,imageFile);

        }catch(IOException e){
            return new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);
        }

        if(product1 != null){
            return new ResponseEntity<>("updated",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product = service.getProduct(id);

        if(product != null){
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestPart String keyword){
        List<Product> products = service.searchProducts(keyword);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
} 
