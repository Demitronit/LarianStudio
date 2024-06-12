package com.example.LarianStudio.Test;

import com.example.LarianStudio.Controllers.MainController;
import com.example.LarianStudio.dal.DataAccessLayer;
import com.example.LarianStudio.models.Coloboration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ColoborationControllerTest {
    @Mock
    private DataAccessLayer dataAccessLayer;

    @InjectMocks
    private MainController mainController;

    @Test
    public void readColoboration() {

       Coloboration testColoboration = new Coloboration("Steam");
        testColoboration.setColoboration_id(1);

        when(dataAccessLayer.readColoboration(1L)).thenReturn(testColoboration);

        ResponseEntity<Coloboration> response = mainController.readColoborationById(1L);

        assertEquals(testColoboration, response.getBody());
    }
}
