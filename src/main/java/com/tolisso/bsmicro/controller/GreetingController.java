package com.tolisso.bsmicro.controller;

import com.tolisso.bsmicro.dto.Greeting;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.tolisso.bsmicro.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class GreetingController {

    private final UserService userService;

    @PutMapping("/put")
    public void put(@RequestParam(value = "name") String name) {
        userService.putUser(name);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam(value = "name") String name) {
        userService.deleteUser(name);
    }

    @GetMapping("/get-all")
    public List<String> getAll() {
        return userService.getUsers();
    }

    @PostMapping("/change-name")
    public void change(@RequestParam(value = "from") String from, @RequestParam(value = "to") String to) {
        userService.changeUser(from, to);
    }
}
