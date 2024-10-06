package com.product;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.product.entitites.Product;
import com.product.repository.ProductRespository;

@SpringBootTest
class ProductJpaApplicationTests {
     @Autowired
	 ProductRespository productRespository;
     
	@Test
	void contextLoads() {
	}

	@Test 
	void testRepository(){
		Product product =Product.builder()
				.sku("Toffee")
				.title("Born_Bun")
				.quantity(4)
				.price(new BigDecimal(123)).build();
		Product savedproduct=productRespository.save(product);
		System.out.println(savedproduct);
	}
	
	@Test
	void getRepository() {
		//List<Product> product= productRespository.findAll();
		//product.forEach(System.out::println);
		List<String> product= productRespository.findByTitleAndPrice("Born_Bun",BigDecimal.valueOf(123));
	    System.out.println(product);
	}
	
	@Test
	void getBydate() {
		List<Product> product= productRespository.findByCreatedAtAfter(LocalDateTime.of(2024, 03, 01, 1, 1));
		product.forEach(prod->System.out.println(prod));
		System.out.println(product);
	}
	
	
	
	
}
