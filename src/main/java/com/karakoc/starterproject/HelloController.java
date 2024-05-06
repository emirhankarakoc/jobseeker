package com.karakoc.starterproject;


import com.karakoc.starterproject.exceptions.general.NotfoundException;
import com.karakoc.starterproject.user.User;
import com.karakoc.starterproject.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class HelloController {
    private final UserRepository repository;
    @GetMapping()
    public String index(){


        return "burada vakit harcama. urlnin sonuna /swagger-ui/index.html koy devam et";
    }
}
