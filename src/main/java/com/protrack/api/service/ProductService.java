package com.protrack.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protrack.api.entity.Product;
import com.protrack.api.repository.IProductRepository;

import lombok.Data;

@Service
@Data
public class ProductService {
    
    @Autowired
    private IProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Optional<Product> getById(Long id){
        return productRepository.findById(id);
    }

    public Optional<Product> getByName(String name){
        return productRepository.findByNameIgnoreCase(name);
    } 

    public Product create(Product product){
        return productRepository.save(product);
    }

    public Product update(Long id,Product productData){
        Optional<Product> existingProduct = productRepository.findById(id);

        if(existingProduct.isPresent()){
            Product product = existingProduct.get();
            product.setName(productData.getName());
            product.setPrice(productData.getPrice());
            product.setDescription(productData.getDescription());
            product.setMinStockQuantity(productData.getMinStockQuantity());
            productRepository.save(product);
            return product;
        }
        else{
            throw new RuntimeException("Product not found");
        }
    }

    public Product UpdateStatus(Long id){
        Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        Product product = existingProduct.get();
        product.setStatus(!product.getStatus());
        productRepository.save(product);
        return product;
     
    }

    public Product UpdateQuantity(Long id,Integer QuantityToAdd){
        Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        Product product = existingProduct.get();
        Integer newQuantity = product.getStockQuantity()+QuantityToAdd;
        product.setStockQuantity(newQuantity);
        productRepository.save(product);
        return product;
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
