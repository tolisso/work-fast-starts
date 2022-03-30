package com.tolisso.bsmicro.repository;

import com.tolisso.bsmicro.dom.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    void removeByName(String name);

    @Transactional()
    void getAllByName(String name);
}
