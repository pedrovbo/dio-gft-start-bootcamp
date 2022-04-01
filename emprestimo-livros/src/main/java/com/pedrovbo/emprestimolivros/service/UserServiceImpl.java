package com.pedrovbo.emprestimolivros.service;

import com.pedrovbo.emprestimolivros.model.User;
import com.pedrovbo.emprestimolivros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Transactional
    public User save(User user){
        return userRepository.save(user);
    }

    public Page<User> findAll(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    @Transactional
    public void delete(User user){
        userRepository.delete(user);
    }
}
