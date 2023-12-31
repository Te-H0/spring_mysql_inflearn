package com.teho.springinflearn.repository;

import com.teho.springinflearn.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    User findByLoginId(String loginId);

}
