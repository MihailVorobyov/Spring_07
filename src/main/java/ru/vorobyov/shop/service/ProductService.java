package ru.vorobyov.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import ru.vorobyov.shop.entities.Product;
import ru.vorobyov.shop.repositories.ProductRepository;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public Page<Product> fromMin(double min, Pageable pageable) {
        return productRepository.findByPriceGreaterThanEqual(min, pageable);
    }
    
    public Page<Product> toMax(double max, Pageable pageable) {
        return productRepository.findByPriceBefore(max, pageable);
    }
    
    public Page<Product> fromMinToMax(double min, double max, Pageable pageable) {
        return productRepository.findByPriceBetween(min, max, pageable);
    }
    
    public Page<Product> findById(long id, Pageable pageable) {
        return productRepository.findById(id, pageable);
    }
    
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    
    public List<Product> findByTitle(String title) {
        return productRepository.findByTitle(title);
    }

    public Product add(Product newProduct) {
        List<Product> pl = findByTitle(newProduct.getTitle());
        if (pl.isEmpty()) {
            return productRepository.save(newProduct);
        }

        return null;
    };
    
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
    
}
