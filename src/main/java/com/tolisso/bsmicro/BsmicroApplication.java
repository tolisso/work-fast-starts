package com.tolisso.bsmicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableAspectJAutoProxy
@SpringBootApplication
public class BsmicroApplication {

    public static void main(String[] args) {
        SpringApplication.run(BsmicroApplication.class, args);
    }
}
