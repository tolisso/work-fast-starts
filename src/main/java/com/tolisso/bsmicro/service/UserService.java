package com.tolisso.bsmicro.service;

import com.tolisso.bsmicro.dom.User;
import com.tolisso.bsmicro.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void putUser(String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
    }

    public void deleteUser(String user) {
        userRepository.removeByName(user);
    }

    public void changeUser(String from, String to) {
        deleteUser(from);
        putUser(to);
    }
}
