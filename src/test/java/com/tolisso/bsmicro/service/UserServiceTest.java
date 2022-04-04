package com.tolisso.bsmicro.service;

import com.tolisso.bsmicro.dom.User;
import com.tolisso.bsmicro.repository.UserRepository;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class UserServiceTest {

    UserRepository userRepositoryMock = mock(UserRepository.class);
    private final UserService userService = new UserService(userRepositoryMock);

    @Test
    public void test() {
        doReturn(Collections.singletonList(new User(1L, "Andrey")))
                .when(userRepositoryMock).findAll();
        Assert.notNull(userService.getUsers(), "список пользвателей - null");
        userService.changeUser("aba", "boba");
        userService.deleteUser("aba");
        userService.putUser("boba");
        verify(userRepositoryMock, times(1)).findAll();
        verify(userRepositoryMock, times(2)).removeByName(any());
        verify(userRepositoryMock, times(2)).save(any());

        verifyNoMoreInteractions(userRepositoryMock);
    }
}
