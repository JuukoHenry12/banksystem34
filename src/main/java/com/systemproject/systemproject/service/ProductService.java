package com.systemproject.systemproject.service;
import java.io.IOException;
import java.security.PublicKey;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.systemproject.systemproject.model.Product;
import com.systemproject.systemproject.repository.ProductRespo;

@Service
public class ProductService {
    @Autowired
    private  ProductRespo productRespo;
    
    public List<Product>getProduct(){
        return productRespo.findAll();
    }

    public Product getProduct(int id) {
        return productRespo.findById(id).orElse(null);
    }

    public Product addProduct(Product product,MultipartFile imageFile)  throws IOException{
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return productRespo.save(product);
    }

    public Product updateProduct(int  id ,Product product,MultipartFile imagFile) throws IOException{

        product.setImageName(imagFile.getOriginalFilename());
        product.setImageType(imagFile.getContentType());
        product.setImageData(imagFile.getBytes());

        return productRespo.save(product);
    }

    public void deleteProduct(int id){
        productRespo.deleteById(id);
    }

    public List<Product>searchProducts(String keyword){
        return productRespo.searchProducts(keyword);
    }
}
