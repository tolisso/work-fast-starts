package com.tolisso.bsmicro.service;

import com.tolisso.bsmicro.dom.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

import static com.tolisso.bsmicro.dom.Role.USER;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private HashMap<String, User> userMap = new HashMap<>();
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (!userMap.containsKey(s)) {
            throw new UsernameNotFoundException(s + " not found");
        }
        return userMap.get(s);
    }

    @PostConstruct
    public void loadData() {
        User user = new User();
        user.setUsername("guest");
        user.setPassword(passwordEncoder.encode("1234"));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setAuthorities(List.of(USER));

        userMap.put(user.getUsername(), user);
    }
}
