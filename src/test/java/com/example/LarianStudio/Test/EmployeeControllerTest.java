package com.example.LarianStudio.Test;

import com.example.LarianStudio.Controllers.MainController;
import com.example.LarianStudio.dal.DataAccessLayer;
import com.example.LarianStudio.models.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @Mock
    private DataAccessLayer dataAccessLayer;

    @InjectMocks
    private MainController mainController;

    @Test
    public void readEmployee(){
        Employee testEmployee = new Employee("Саша", "Sanya" , 123456789);
        testEmployee.setEmployee_id(1);

        when(dataAccessLayer.readEmployee(1L)).thenReturn(testEmployee);

        ResponseEntity<Employee> response = mainController.readEmployeeById(1L);

        assertEquals(testEmployee, response.getBody());
    }
}
