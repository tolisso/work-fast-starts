package com.tolisso.bsmicro.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private Set<String> userSet = new HashSet<>();

    public List<String> getUsers() {
        return new ArrayList<>(userSet);
    }

    public void putUser(String user) {
        userSet.add(user);
    }

    public void deleteUser(String user) {
        userSet.remove(user);
    }

    public void changeUser(String from, String to) {
        deleteUser(from);
        putUser(to);
    }
}
