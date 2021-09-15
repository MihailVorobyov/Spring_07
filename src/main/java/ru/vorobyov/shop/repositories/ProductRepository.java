package ru.vorobyov.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vorobyov.shop.entities.Product;

import java.util.List;

@Repository
//@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findById(long id);
	
	List<Product>  findByPriceAfter(double max);
	
	List<Product> findByPriceBefore(double min);
	
	List<Product> findByPriceAfterAndPriceBefore(double min, double max);
	
	List<Product> findAll();
	
	Product save(Product newProduct);

}
