package com.teho.springinflearn.service;

import com.teho.springinflearn.domain.User;
import com.teho.springinflearn.dto.UserRegistDTO;
import com.teho.springinflearn.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private User dtoToEntity(UserRegistDTO dto) {
        User entity = new User(dto.getName(), dto.getLogin_id(), dto.getPw(),
                dto.getEmail(), dto.getAge(), dto.getAddress());

        return entity;
    }

    @Transactional
    public Long join(UserRegistDTO user) {
        User entity = dtoToEntity(user);
        userRepository.save(entity);

        return entity.getId();
    }

    public List<User> showUsers() {
        return userRepository.findAll();
    }


}
