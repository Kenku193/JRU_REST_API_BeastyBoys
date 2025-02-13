package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository repo;

    public Optional<User> findById(Long id){
        // Where is my DTO?
        return repo.findById(id);

    }

    public List<User> findAll(){
        List<User> all = repo.findAll();
        return all;
    }

    @Transactional
    public User save(User user){
        repo.save(user);
        return user;
    }

    @Transactional
    public User update(User user){
        repo.updateLoginAndPasswordById(user.getLogin(), user.getPassword(), user.getId());
        return user;
    }

    @Transactional
    public void delete(User user){
        repo.delete(user);
    }

    @Transactional
    public void deleteById(Long id){
        repo.deleteById(id);
    }

    public Optional<User> findByLoginAndPassword(String login, String password){
        return repo.findByLoginAndPassword(login, password);
    }
}
