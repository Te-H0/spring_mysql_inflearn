//package com.teho.springinflearn.repository;
//
//import com.teho.springinflearn.domain.User;
//import jakarta.persistence.EntityManager;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
////@Repository
//@Slf4j
//@RequiredArgsConstructor
//public class UserRepositoryImpl implements UserRepository {
//
//    private final EntityManager em;
//
//    @Override
//    @Transactional
//    public void save(User user) {
//        em.persist(user);
//    }
//
//    @Override
//    public User findOne(Long id) {
//        return em.find(User.class, id);
//    }
//
//    @Override
//    public List<User> findAll() {
//        return em.createQuery("select m from User m", User.class).
//                getResultList();
//    }
//
//    @Override
//    public User findByLoginId(String loginId) {
//        List<User> loginUserId = em.createQuery("select m from User m where m.login_id =:loginId", User.class)
//                .setParameter("loginId", loginId)
//                .getResultList();
//
//        log.info("로그인했을 때 없을때 넘어오는 리스트 결과! ==>{}, 리스트는 비어있나??==>{}", loginUserId, loginUserId.isEmpty());
//        if (loginUserId.isEmpty())
//            return null;
//
//        return loginUserId.get(0);
//
//    }
//}
