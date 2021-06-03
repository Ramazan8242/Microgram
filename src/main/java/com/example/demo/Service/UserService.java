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

    public List<UserDTO> findUserByName(String name) {
        List<User> names = userRepository.findBy(name);
        List<UserDTO> users = new ArrayList<>();
        for (User user : names) {
            users.add(UserDTO.from(user));
        }
        return users;
    }

    public UserDTO addUser(User user) {
        return UserDTO.from(userRepository.save(User.createUser(user.getUsername(), user.getEmail(),user.getPassword())));
    }

    public UserDTO findUserByLogin(String username) {
        return UserDTO.from(userRepository.findByUsername(username));
    }

    public UserDTO findUserByEmail(String email) {
        return UserDTO.from(userRepository.findByEmail(email).get());
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

    public User getUser() {
        Random r = new Random();
        List<User> users = new ArrayList<>(userRepository.findAll());
        return users.get(r.nextInt(users.size()));
    }
}
