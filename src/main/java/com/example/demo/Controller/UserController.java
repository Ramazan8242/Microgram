package com.example.demo.Controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/registration")
    public UserDTO signUp(@RequestBody User user) throws Exception {
        if (userService.existsThereAnyUserByEmail(user.getEmail())) {
            throw new Exception("There is a User with this email " + user.getEmail());
        } else if (userService.existsThereAnyUserByUsername(user.getUsername())) {
            throw new Exception(("There is a User with this login" + user.getUsername()));
        }
        return userService.addUser(user);
    }

    @GetMapping("/search/name")
    public List<UserDTO> findUsersByName(@RequestParam("name") String name) {
        return userService.findUserByName(name);
    }

    @GetMapping("/search/login")
    public UserDTO findUserByLogin(@RequestParam("login") String login) {
        return userService.findUserByLogin(login);
    }

    @GetMapping("/search/email/")
    public UserDTO findUserByEmail(@RequestParam("email") String email) {
        return userService.findUserByEmail(email);
    }
}
