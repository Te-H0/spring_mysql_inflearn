package com.teho.springinflearn.repository;

import com.teho.springinflearn.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final EntityManager em;

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select m from User m", User.class).
                getResultList();
    }

    @Override
    public Optional<User> findByLoginId(String loginId) {
        List<User> loginUserId = em.createQuery("select m from User m where m.login_id =:loginId", User.class)
                .setParameter("loginId", loginId)
                .getResultList();
        if (loginUserId.isEmpty())
            return Optional.empty();

        User loginUser = loginUserId.get(0);
        return Optional.ofNullable(loginUser);

    }
}
