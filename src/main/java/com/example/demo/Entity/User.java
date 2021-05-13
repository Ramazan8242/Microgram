package com.example.demo.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Document(collection = "users")
public class User implements UserDetails {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String username;
    private String email;
    private String password;

    public static User createUser(String name, String username, String email) {
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setEmail(email);
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("FULL"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
