package com.teho.springinflearn.service;

import com.teho.springinflearn.domain.Category;
import com.teho.springinflearn.domain.Course;
import com.teho.springinflearn.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
