package com.teho.springinflearn.repository;

import com.teho.springinflearn.domain.User;

import java.util.List;

public interface UserRepository {
    void save(User user);

    User findOne(Long id);

    List<User> findAll();

    User findByLoginId(String loginId);

}
