package com.product.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entitites.Product;
import com.product.repository.ProductRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

   private final ProductRespository productRespository;
   private final int PAGE_SIZE=3;
   
   @GetMapping("/all")
   public List<Product> getProduct(){
	   return productRespository.findByOrderByPrice();
   }
   
   @GetMapping("/ad")
   public List<Product> getMethodName(@RequestParam(defaultValue = "id") String sortBy) {
       return productRespository.findAll(Sort.by(Sort.Order.asc(sortBy),Sort.Order.desc("quantity")));
   }
   
   @GetMapping
   public List<Product> getAllByPage(@RequestParam(defaultValue = "0") Integer pageNumber ){
	   Pageable pageable=PageRequest.of(pageNumber, PAGE_SIZE);
	   return productRespository.findAll(pageable).getContent();
	  // return productRespository.findAll(pageable);//If u need extra meta data
   }
   
}
