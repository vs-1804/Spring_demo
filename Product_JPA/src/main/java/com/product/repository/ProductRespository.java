package com.product.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.entitites.Product;

@Repository
public interface ProductRespository  extends JpaRepository<Product, Long>{
	
	List<Product> findByCreatedAtAfter(LocalDateTime after);
	
	@Query("select p.title , p.price from Product p where p.title=?1 and p.price=?2" )
	List<String> findByTitleAndPrice(String title, BigDecimal price);

	List<Product> findByOrderByPrice();
	
	List<Product> findBy(Sort sort);
	
	Page<Product> findAll(Pageable pageable);

}
