package com.example.LarianStudio.Controllers;

import com.example.LarianStudio.Events.EventLogger;
import com.example.LarianStudio.dal.DataAccessLayer;
import com.example.LarianStudio.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/autorizeted")
public class AdminController {
    private final DataAccessLayer dataAccessLayer;
    @Autowired
    private EventLogger eventLogger;
    @Autowired
    public AdminController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }
    /////////////////////////////Game////////////////////////////////
    @PostMapping("/newgame/")
    public ResponseEntity createGameToDatabase(@RequestBody Game game) {
        dataAccessLayer.createGameToDatabase(game);
        eventLogger.logEvent("New game created: " + game.getName());

        return ResponseEntity.ok("Game added successfully");
    }

    @DeleteMapping("/deletegame/{id}")
    public ResponseEntity deleteGameById(@PathVariable ("id") long id){
        dataAccessLayer.deleteGame(id);
        return ResponseEntity.ok("Delete game");
    }
    @PostMapping("/game/{id}")
    public ResponseEntity updateGameById(@PathVariable("id")
                                         long id ,@RequestBody Game newGame){
        dataAccessLayer.updateGame(id, newGame);
        return ResponseEntity.ok("Update game");

    }
    //////////////////////////Coloboration//////////////////////
    @PostMapping("/newcoloboration")
    public ResponseEntity createColoborationToDatabase(@RequestBody Coloboration coloboration) {
        dataAccessLayer.createColoborationToDatabase(coloboration);
        return ResponseEntity.ok("Add coloboration");
    }

    @DeleteMapping("/coloboration/{id}")
    public ResponseEntity deleteColoborationById(@PathVariable ("id") long id){
        dataAccessLayer.deleteColoboration(id);
        return ResponseEntity.ok("Delete coloboration");
    }
    @PostMapping("/coloboration/{id}")
    public ResponseEntity updateColoborationById(@PathVariable("id") long id ,@RequestBody Coloboration newColoboration){
        dataAccessLayer.updateColoboration(id, newColoboration);
        return ResponseEntity.ok("Update coloboration");

    }
    //////////////////////////////////////Dlc//////////////////////////
    @PostMapping("/newdlc")
    public ResponseEntity createDlcToDatabase(@RequestBody Dlc dlc) {
        dataAccessLayer.createDlcToDatabase(dlc);
        return ResponseEntity.ok("Add dlc");
    }

    @DeleteMapping("/dlc/{id}")
    public ResponseEntity deleteDlcById(@PathVariable ("id") long id){
        dataAccessLayer.deleteDlc(id);
        return ResponseEntity.ok("Delete dlc");
    }
    @PostMapping("/dlc/{id}")
    public ResponseEntity updateDlcById(@PathVariable("id") long id ,@RequestBody Dlc newDlc){
        dataAccessLayer.updateDlc(id, newDlc);
        return ResponseEntity.ok("Update dlc");

    }
    ///////////////////////////////Employee////////////////////////////
    @PostMapping("/newemployee")
    public ResponseEntity createEmployeeToDatabase(@RequestBody Employee employee) {
        dataAccessLayer.createEmployeeToDatabase(employee);
        return ResponseEntity.ok("Add Employee");
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity deleteEmployeeById(@PathVariable ("id") long id){
        dataAccessLayer.deleteEmployee(id);
        return ResponseEntity.ok("Delete employee");
    }
    @PostMapping("/employee/{id}")
    public ResponseEntity updateEmployeeById(@PathVariable("id") long id ,@RequestBody Employee newEmployee) {
        dataAccessLayer.updateEmployee(id, newEmployee);
        return ResponseEntity.ok("Update employee");
    }
    ///////////////////////////////////Larian_Studio////////////////////////////////
    @PostMapping("/larian")
    public ResponseEntity updateLarian(@PathVariable("id") long String ,@RequestBody Larian_Studio newLarianStudio) {
        dataAccessLayer.updateLarian(String, newLarianStudio);
        return ResponseEntity.ok("Update Larian");
    }
    ///////////////////////////////Launcher/////////////////////////
    @PostMapping("/launcher")
    public ResponseEntity updateLauncher(@PathVariable("id") long id ,@RequestBody Launcher newLauncher) {
        dataAccessLayer.updateLauncher(id, newLauncher);
        return ResponseEntity.ok("Update launcher");
    }
    ///////////////////////////Story_pay////////////////////////////////
    @PostMapping("/story_pay")
    public ResponseEntity createStoryPay(@RequestBody Story_pay newStoryPay) {
        dataAccessLayer.createStoryPay(newStoryPay);
        return ResponseEntity.ok("Add story pay");
    }

    @DeleteMapping("/story_pay/{id}")
    public ResponseEntity deleteStoryPayById(@PathVariable ("id") long id){
        dataAccessLayer.deleteStoryPayById(id);
        return ResponseEntity.ok("Delete story pay");
    }
    @PostMapping("/story_pay/{id}")
    public ResponseEntity updateStoryPayById(@PathVariable("id") long id ,@RequestBody Story_pay newStoryPay) {
        dataAccessLayer.updateStoryPayById(id, newStoryPay);
        return ResponseEntity.ok("Update story pay");
    }
    ///////////////////////////////User////////////////////////////////
    @PostMapping("/user")
    public ResponseEntity createUserToDatabase(@RequestBody User newUser) {
        dataAccessLayer.createUserToDatabase(newUser);
        return ResponseEntity.ok("Add user");
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUserById(@PathVariable ("id") long id){
        dataAccessLayer.deleteUser(id);
        return ResponseEntity.ok("Delete user");
    }
    @PostMapping("/user/{id}")
    public ResponseEntity updateUserById(@PathVariable("id") long id ,@RequestBody User newUser) {
        dataAccessLayer.updateUser(id, newUser);
        return ResponseEntity.ok("Update user");
    }



}