package com.hardwin.ecommerce.repository;

import com.hardwin.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
    Category findByName(String name);

    boolean existsByName(String name);
}
