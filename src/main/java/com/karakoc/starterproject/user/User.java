package com.karakoc.starterproject.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.karakoc.starterproject.cv.scheme.CVSchema;
import com.karakoc.starterproject.user.requests.RegisterRequest;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class User {
    @Id
    private String id;
    private String username;
    private String password;

    private String firstname;
    private String lastname;
    private LocalDateTime birthDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String mail;
    private String phoneNumber;
    @Enumerated
    private UserType type;
    private String token;//mistik.


    @OneToMany
    @JoinColumn(name = "cvschemaId")
    private List<CVSchema> cvs;


    public static User createSimpleUser(RegisterRequest r) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername(r.getUsername());
        // Şifreyi BCrypt ile hashle
        String hashedPassword = BCrypt.withDefaults().hashToString(12, r.getPassword().toCharArray());
        user.setPassword(hashedPassword);
        user.setFirstname(r.getFirstname());
        user.setLastname(r.getLastname());
        user.setBirthDate(r.getBirthDate());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setMail(r.getMail());
        user.setPhoneNumber(r.getPhoneNumber());
        user.setType(UserType.USER);
        return user;
    }

    public static void updateUser(User u) {
        u.setUpdatedAt(LocalDateTime.now());
    }

    public static UserDTO userToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setMail(user.getMail());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setFirstname(user.getFirstname());
        dto.setLastname(user.getLastname());
        dto.setBirthDate(user.getBirthDate());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        dto.setType(user.getType());
        return dto;
    }
}
