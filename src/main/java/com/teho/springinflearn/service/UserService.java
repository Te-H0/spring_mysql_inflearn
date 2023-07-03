package com.teho.springinflearn.service;

import com.teho.springinflearn.domain.User;
import com.teho.springinflearn.dto.UserLoginDTO;
import com.teho.springinflearn.dto.UserRegistDTO;
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

    private User dtoToEntity(UserRegistDTO dto) {
        User entity = new User(dto.getName(), dto.getLogin_id(), dto.getPw(),
                dto.getEmail(), dto.getAge(), dto.getAddress());

        return entity;
    }

    public UserLoginDTO login(UserLoginDTO userLoginDTO) {
        String login_id = userLoginDTO.getLogin_id();
        User user = userRepository.findByLoginId(login_id);
        log.info("서비스에서 찾은 유저의 이름 ==>{}", user.getName());


        if (user == null)
            return null;
        else {
            if (userLoginDTO.getPw().equals(user.getPw())) {
                log.info("비번일치했어!!");
                userLoginDTO.setName(user.getName());
                return userLoginDTO;
            } else {
                return null;
            }

        }
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
