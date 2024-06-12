package com.example.LarianStudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.LarianStudio.dto.UserDto;
import com.example.LarianStudio.models.User;
import com.example.LarianStudio.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public User addUser(UserDto accountDto) {
        User user = new User();
        user.setName(accountDto.getName());
        user.setAge(accountDto.getAge());

        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setLogin(accountDto.getLogin());
        userRepository.save(user);

        return user;
    }

    public void loginUser(UserDto accountDto) {
        UsernamePasswordAuthenticationToken authReq
                = new UsernamePasswordAuthenticationToken(accountDto.getLogin(), accountDto.getPassword());
        Authentication auth = authenticationManager.authenticate(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
    }

    public User saveUser(UserDto accountDto) {
        User user = new User();
        user.setName(accountDto.getName());
        user.setAge(accountDto.getAge());
        user.setPassword(accountDto.getPassword());
        user.setLogin(accountDto.getLogin());


        userRepository.save(user);
        return user;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    }
