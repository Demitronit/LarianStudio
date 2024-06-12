package com.example.LarianStudio.Test;

import com.example.LarianStudio.Controllers.MainController;
import com.example.LarianStudio.dal.DataAccessLayer;
import com.example.LarianStudio.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

    @ExtendWith(MockitoExtension.class)
    public class UserControllerTest {

    @Mock
    private DataAccessLayer dataAccessLayer;
    @InjectMocks
    private MainController mainController;

    @Test
    public void readUser() {
       User testUser = new User("Demitronit", "123456789" , "Денис" , 20 );
        testUser.setUser_id(1L);

        when(dataAccessLayer.readUser(1L)).thenReturn(testUser);

       ResponseEntity<User> response = mainController.readUserById(1L);

        assertEquals(testUser, response.getBody());

    }
}
