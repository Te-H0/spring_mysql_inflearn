package com.teho.springinflearn.service;

import com.teho.springinflearn.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestService {
    private final CourseService courseService;
    private final UserService userService;
    private final CategoryRepository categoryRepository;


}
