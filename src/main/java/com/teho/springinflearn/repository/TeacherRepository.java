package com.teho.springinflearn.repository;

import com.teho.springinflearn.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    public Teacher findByName(String name);

    List<Teacher> findAllByNameContaining(String name);
}
