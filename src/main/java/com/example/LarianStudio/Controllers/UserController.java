package com.example.LarianStudio.Controllers;
import com.example.LarianStudio.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/userNames")
    public List<String> getUserNames() {
        return userRepository.findNamesOnly();
    }
}