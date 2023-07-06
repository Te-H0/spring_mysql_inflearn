package com.teho.springinflearn.repository;

import com.teho.springinflearn.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<User, Long> {
}
