package com.karakoc.starterproject.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

    Optional<User> findUserByUsernameOrMailOrPhoneNumber(String username,String mail, String phoneNumber);

    Optional<User> existsByUsername(String username);

    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findByMail(String mail);

    Optional<User> findByToken(String token);

}
