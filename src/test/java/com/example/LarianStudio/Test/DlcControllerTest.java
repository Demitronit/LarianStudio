package com.example.LarianStudio.Test;

import com.example.LarianStudio.Controllers.MainController;
import com.example.LarianStudio.dal.DataAccessLayer;
import com.example.LarianStudio.models.Dlc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DlcControllerTest {

    @Mock
    private DataAccessLayer dataAccessLayer;

    @InjectMocks
    private MainController mainController;

    @Test
    public void readDlc() {

        Dlc testDlc = new Dlc("Blood And Vine", 1500, "Cool dlc");
        testDlc.setDlc_id(1);

        when(dataAccessLayer.readDlc(1L)).thenReturn(testDlc);

        ResponseEntity<Dlc> response = mainController.readDlcById(1L);

        assertEquals(testDlc, response.getBody());
    }
}
