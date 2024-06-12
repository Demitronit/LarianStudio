package com.example.LarianStudio.Controllers;

import com.example.LarianStudio.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.LarianStudio.dal.DataAccessLayer;
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/")
public class MainController {
    private final DataAccessLayer dataAccessLayer;
    @Autowired
    public MainController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }
///////////////////////////////////Game//////////////////////////////////////////////////

    @GetMapping("/game/{id}")
    public ResponseEntity<Game> readGameById(@PathVariable("id") long id){
        Game game = dataAccessLayer.readGame(id);
        if(game != null) {
            return ResponseEntity.ok(game);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    ///////////////////////////////////Coloboraation//////////////////////////////////////////////////


    @GetMapping("/coloboration/{id}")
    public ResponseEntity<Coloboration> readColoborationById(@PathVariable("id") long id){
        Coloboration coloboration = dataAccessLayer.readColoboration(id);
        if(coloboration != null) {
            return ResponseEntity.ok(coloboration);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    ///////////////////////////////////DLC//////////////////////////////////////////////////


    @GetMapping("/dlc/{id}")
    public ResponseEntity<Dlc> readDlcById(@PathVariable("id") long id){
        Dlc dlc = dataAccessLayer.readDlc(id);
        if(dlc != null) {
            return ResponseEntity.ok(dlc);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    ///////////////////////////////////Employee//////////////////////////////////////////////////

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> readEmployeeById(@PathVariable("id") long id){
        Employee employee = dataAccessLayer.readEmployee(id);
        if(employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
///////////////////////////////////Larian_Studio//////////////////////////////////////////////////
    @GetMapping("/larian")
    public  ResponseEntity readLarian(@PathVariable("id") long String){
        dataAccessLayer.readLarian(String);
        return  ResponseEntity.ok("Read employee");
    }

///////////////////////////////////Launcher//////////////////////////////////////////////////

    @GetMapping("/launcher")
    public  ResponseEntity readLauncher(@PathVariable("id") long String){
        dataAccessLayer.readLauncher(String);
        return  ResponseEntity.ok("Read launcher");
    }


///////////////////////////////////Story_pay//////////////////////////////////////////////////


    @GetMapping("/story_pay/{id}")
    public  ResponseEntity readStoryPayById(@PathVariable("id") long id){
        dataAccessLayer.readStoryPayById(id);
        return  ResponseEntity.ok("Read story pay");
    }


///////////////////////////////////User//////////////////////////////////////////////////


    @GetMapping("/user/{id}")
    public ResponseEntity<User> readUserById(@PathVariable("id") long id){
        User user = dataAccessLayer.readUser(id);
        if(user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
