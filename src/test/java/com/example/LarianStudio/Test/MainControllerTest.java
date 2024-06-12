package com.example.LarianStudio.Test;

import com.example.LarianStudio.Controllers.MainController;
import com.example.LarianStudio.dal.DataAccessLayer;
import com.example.LarianStudio.models.Game;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MainControllerTest {

    @Mock
    private DataAccessLayer dataAccessLayer;

    @InjectMocks
    private MainController mainController;

    @Test
    public void readGame() {

        Game testGame = new Game("BG3", 3000, "Cool game");
        testGame.setGame_id(1);

        when(dataAccessLayer.readGame(1L)).thenReturn(testGame);

        ResponseEntity<Game> response = mainController.readGameById(1L);

        assertEquals(testGame, response.getBody());
    }

}
