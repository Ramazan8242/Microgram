package com.example.demo.Service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDTO addUser(User user) {
        return UserDTO.from(userRepository.save(User.createUser(user.getName(), user.getUsername(), user.getEmail())));
    }

    public boolean existsThereAnyUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsThereAnyUserByUsername(String login) {
        return userRepository.existsByUsername(login);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("user with email %s not found", s)));
    }
}
