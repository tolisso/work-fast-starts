package com.tolisso.bsmicro.service;

import com.tolisso.bsmicro.dom.User;
import com.tolisso.bsmicro.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
