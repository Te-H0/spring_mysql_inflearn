package com.teho.springinflearn.repository;

import com.teho.springinflearn.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Category findByName(String name);

    List<Category> findAllByNameContaining(String name);
}
