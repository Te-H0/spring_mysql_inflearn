package com.teho.springinflearn.repository;

import com.teho.springinflearn.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);

    User findOne(Long id);

    List<User> findAll();

    Optional<User> findByLoginId(String loginId);

}
