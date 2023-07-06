package com.teho.springinflearn.repository;

import com.teho.springinflearn.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Category findByName(String name);
}
