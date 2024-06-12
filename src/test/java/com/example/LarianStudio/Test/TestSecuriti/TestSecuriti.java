package com.example.LarianStudio.Test.TestSecuriti;

import com.example.LarianStudio.Controllers.SecurityController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.LarianStudio.models.User;
import com.example.LarianStudio.service.UserService;
import com.example.LarianStudio.Repository.UserRepository;
import com.example.LarianStudio.dto.UserDto;

@SpringBootTest
public class TestSecuriti {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Autowired
    public TestSecuriti(UserService userService) {
        this.userService = userService;
    }

    @MockBean
    SecurityController securityController;

    @Test
    public void AuthLogin() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setLogin("demitronit@gmail.com");
        userDto.setName("Denis");
        userDto.setAge(20);
        userDto.setPassword("123456789");
        securityController.getLoginPage(userDto);
    }

    @Test
    void registerNewUserAccount() {
        UserDto userDto = new UserDto();
        User user = userService.addUser(userDto);
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }
}
