package ru.vorobyov.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vorobyov.shop.entities.Product;
import ru.vorobyov.shop.repositories.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
//@Persistent
//@Transactional
public class ProductService {
    
//    @PersistenceContext
//    private EntityManager em;
//
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> fromMin(double min) {
        return productRepository.findByPriceAfter(min);
    }

    public List<Product> toMax(double max) {
        return productRepository.findByPriceBefore(max);
    }

    public List<Product> fromMinToMax(double min, double max) {
        return productRepository.findByPriceAfterAndPriceBefore(min, max);
    }
    
    public List<Product> findById (long id) {
        return productRepository.findById(id);
    }
    
    public List<Product> findAll () {
        return productRepository.findAll();
    }
    
    public void add(Product newProduct) {
//        em.getTransaction().begin();
//        em.persist(newProduct);
//        em.getTransaction().commit();
        productRepository.save(newProduct);
    };
    
}
