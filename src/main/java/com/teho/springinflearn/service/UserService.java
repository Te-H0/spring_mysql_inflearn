package com.teho.springinflearn.service;

import com.teho.springinflearn.domain.User;
import com.teho.springinflearn.dto.UserLoginForm;
import com.teho.springinflearn.dto.UserRegistForm;
import com.teho.springinflearn.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private User dtoToEntity(UserRegistForm dto) {
        User entity = new User(dto.getName(), dto.getLogin_id(), dto.getPw(),
                dto.getEmail(), dto.getAge(), dto.getAddress());

        return entity;
    }

    public User login(UserLoginForm userLoginForm) {
        String login_id = userLoginForm.getLogin_id();
        Optional<User> byLoginId = userRepository.findByLoginId(login_id);

        if (byLoginId.isEmpty())
            return null;

        User user = byLoginId.get();
        log.info("서비스에서 찾은 유저의 이름 ==>{}", user.getName());


        if (userLoginForm.getPw().equals(user.getPw())) {
            log.info("비번일치했어!!");
            userLoginForm.setName(user.getName());
            return user;
        } else {
            log.info("비밀번호 불일치!!");
            return null;
        }


    }

    @Transactional
    public Long join(UserRegistForm user) {
        User entity = dtoToEntity(user);
        userRepository.save(entity);

        return entity.getId();
    }

    public List<User> showUsers() {
        return userRepository.findAll();
    }


}
