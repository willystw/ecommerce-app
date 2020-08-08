package com.ecommerce.user.application;

import com.ecommerce.user.entity.User;
import com.ecommerce.user.repository.UserDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackageClasses = {User.class})
@EnableJpaRepositories(basePackageClasses = {UserDataRepository.class})
public class UserApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
