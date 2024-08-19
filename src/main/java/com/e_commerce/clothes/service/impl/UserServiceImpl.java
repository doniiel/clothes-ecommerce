package com.e_commerce.clothes.service.impl;

import com.e_commerce.clothes.domain.entity.user.Role;
import com.e_commerce.clothes.domain.entity.user.User;
import com.e_commerce.clothes.domain.exception.ResourceNotFoundException;
import com.e_commerce.clothes.repository.UserRepository;
import com.e_commerce.clothes.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Encoder;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User with id: " + id +" not found")
        );
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new ResourceNotFoundException("User with username: " + username + " not found")
        );
    }

    @Override
    public User getByPhoneNumber(String number) {
//        return userRepository.findByPhoneNumber(number).orElseThrow(
//                () -> new UsernameNotFoundException("User with phoneNumber: " + number + " not found")
//        );
        return null;
    }

    @Override
    public List<User> getByRole(Role role) {
        return userRepository.findByRole(role);
    }

    @Override
    public boolean existUser(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User create(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException("User already exist");
        }
        if (!user.getPassword().equals(user.getPasswordConfirmation())) {
            throw new IllegalStateException("User password not match");
        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);
        return user;
    }

    @Override
    public User update(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        if (userRepository.findById(id).isPresent()) {
            throw new ResourceNotFoundException("User not found");
        }
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }
}
