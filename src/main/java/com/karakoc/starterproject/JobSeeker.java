package com.karakoc.starterproject;

import com.karakoc.starterproject.security.JWTService;
import com.karakoc.starterproject.user.User;
import com.karakoc.starterproject.user.UserRepository;
import com.karakoc.starterproject.user.UserType;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class JobSeeker {

    public static void main(String[] args) {
        SpringApplication.run(JobSeeker.class, args);
    }
    @Component
    @AllArgsConstructor
    public class MyCommandLineRunner implements CommandLineRunner {
        private final UserRepository repository;
        private final JWTService jwtService;
        @Override
        public void run(String... args) throws Exception {
            User user = new User();
            user.setId("emirhan1");
            user.setType(UserType.ADMIN);
            user.setToken(jwtService.generateToken("emirhan1"));


            repository.save(user);
            System.out.println(user.getToken());

        }
        }

}
