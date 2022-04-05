package com.tolisso.bsmicro;

import com.tolisso.bsmicro.kafka.input.ConsumerChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableAspectJAutoProxy
@EnableBinding({ConsumerChannels.class})
@IntegrationComponentScan
@SpringBootApplication
public class BsmicroApplication {

    public static void main(String[] args) {
        SpringApplication.run(BsmicroApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
