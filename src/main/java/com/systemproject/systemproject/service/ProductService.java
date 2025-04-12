package com.systemproject.systemproject.service;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import com.systemproject.systemproject.model.Product;


@Service
public class ProductService {

    List <Product> products = Arrays.asList(
        new Product(012,"Nike Shoes",145000),
        new Product(034,"water proof bag",50000),
        new Product(056,"Apple Watch",200000),
        new Product(002,"Samsung TV",800000),
        new Product(003,"Sony Headphones",30000)

    );
    
    public List<Product>getProduct(){
        return products;

    }

    public Product getProductById(int id) {
        return products.stream()
        .filter(product -> product.getProdId() == id)
        .findFirst()
        .orElse(null);
    }

    public void addProduct(Product product) {
        products.add(product);

    }

    public void updateProduct(Product prod){

        int index =0;

        for(int i =0 ; i<products.size();i++){
            if(products.get(i).getProdId() == prod.getProdId()){
                index=i;
                products.set(index, prod);
            }
        }
    }

    public void deleteProduct(int prodId){
        int index =0;
        
        for(int i =0 ; i<products.size();i++){
            if(products.get(i).getProdId() == prodId){
                index=i;
                products.remove(index);
            }
        }
    }
}
