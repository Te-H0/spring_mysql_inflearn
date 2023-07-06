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
        log.info("여기냐1");

        User loginUser = userRepository.findByLoginId(login_id);

        log.info("여기냐2");
        if (loginUser == null)
            return null;


        log.info("서비스에서 찾은 유저의 이름 ==>{}", loginUser.getName());


        if (userLoginForm.getPw().equals(loginUser.getPw())) {
            log.info("비번일치했어!!");
            userLoginForm.setName(loginUser.getName());
            return loginUser;
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
