package com.hardwin.ecommerce.repository;

import com.hardwin.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryName(String category);
    List<Product> findByBrand(String category);
    List<Product> findByName(String category);
    List<Product> findByCategoryNameAndBrand(String category, String name);
    List<Product> findByBrandAndName(String brand, String name);

    Long countByBrandAndName(String brand, String name);
}
