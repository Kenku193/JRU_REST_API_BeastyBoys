package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query("update User u set u.login = ?1, u.password = ?2 where u.id = ?3")
    int updateLoginAndPasswordById(String login, String password, Long id);
    Optional<User> findByLoginAndPassword(String login, String password);
}
