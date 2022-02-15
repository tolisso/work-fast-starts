package ru.diasoft.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableCaching
@ComponentScan({"ru.diasoft.micro"})
@SpringBootApplication
public class EmalkoApplication {

    @SuppressWarnings({"java:S1148", "Diasoft-Java-Custom:FindReflectionCheck"})
    public static void main(String[] args) {
        try {
            SpringApplication.run(EmalkoApplication.class, args);
        } catch (RuntimeException ex) {
            if (!ex.getClass().getSimpleName().contains("SilentExitException")) {
                ex.printStackTrace();
            }
            throw ex;
        }
    }

}
