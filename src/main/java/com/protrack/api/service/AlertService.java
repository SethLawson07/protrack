package com.protrack.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protrack.api.entity.Alert;
import com.protrack.api.entity.Product;
import com.protrack.api.repository.IAlertRepository;
import com.protrack.api.repository.IProductRepository;

import lombok.Data;

@Service
@Data
public class AlertService {
    
    @Autowired
    private IAlertRepository alertRepository;

    @Autowired
    private IProductRepository productRepository;

    public List<Alert> getAll(){
        return alertRepository.findAll();
    }

    public Optional<Alert> getById(Long id){
        return alertRepository.findById(id);
    }

    public void create(){
        List<Product> products = productRepository.findAll();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if(product.getStockQuantity()<=product.getStockQuantity()){
                Alert alert = new Alert();
                alert.setProduct(product);
                alertRepository.save(alert);
            }
        }
    }

    public void closeALert(Long id){
        alertRepository.deleteById(id);
    }
}
