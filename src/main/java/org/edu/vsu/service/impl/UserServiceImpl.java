package org.edu.vsu.service.impl;

import org.edu.vsu.dao.UserRepository;
import org.edu.vsu.entity.User;
import org.edu.vsu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByName(String name) {
        return this.userRepository.findByName(name);
    }

    @Override
    public User create(User entity) {
        return this.userRepository.saveAndFlush(entity);
    }

    @Override
    public User get(Long id) {
        return this.userRepository.getOne(id);
    }

    @Override
    public User update(User entity) {
        return this.userRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }
}
