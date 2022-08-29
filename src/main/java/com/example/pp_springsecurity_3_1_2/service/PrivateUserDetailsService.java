package com.example.pp_springsecurity_3_1_2.service;

import com.example.pp_springsecurity_3_1_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrivateUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public PrivateUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException(String.format("Пользователь %s не найден.", username)));
    }
}
