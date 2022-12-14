package com.example.pp_springsecurity_3_1_2.service;

import com.example.pp_springsecurity_3_1_2.model.User;
import com.example.pp_springsecurity_3_1_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User passwordCoder(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getById(id);
    }

    public void addUser(User user) {
        userRepository.save(passwordCoder(user));
    }

    @Override
    public void updateUser(User user) {
        User userToBeUpdated = userRepository.getById(user.getId());
        userToBeUpdated.setUsername(user.getUsername());
        userToBeUpdated.setPassword(user.getPassword());
        userToBeUpdated.setSurname(user.getSurname());
        userToBeUpdated.setAge(user.getAge());
        userToBeUpdated.setEmail(user.getEmail());
        userToBeUpdated.setRoles(user.getRoles());
        userRepository.flush();
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
