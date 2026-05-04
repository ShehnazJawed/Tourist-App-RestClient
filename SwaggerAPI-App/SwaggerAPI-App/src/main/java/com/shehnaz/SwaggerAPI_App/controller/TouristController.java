package com.shehnaz.SwaggerAPI_App.controller;

import com.shehnaz.SwaggerAPI_App.entity.Tourist;
import com.shehnaz.SwaggerAPI_App.iservice.ITouristService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourist")
@Tag(name="Tourist Controller",description = "API managing Tourist")
public class TouristController{

    @Autowired
    private ITouristService iTouristService;

    @PostMapping("/register")
    @Operation(summary = "Register a new Tourist",description = "Adds a new Tourists to the System")
    public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist){
        String touristDb = iTouristService.addTourist(tourist);
        return new ResponseEntity<String>(touristDb, HttpStatus.CREATED);
    }

    @PatchMapping("/updateTourist/{id}/{budget}")
    @Operation(summary = "update the Tourist budget",description = "Update the budget of a Tourist based on thier id")
    public ResponseEntity<String> updateTouristBudget(@PathVariable("id") Integer id,@PathVariable("budget") Double budget){
        String tourist = iTouristService.updateTourist(id, budget);
        return new ResponseEntity<String>(tourist,HttpStatus.OK);
    }

    @PutMapping("/updateTourist")
    @Operation(summary = "Update Tourist Information",description = "Updates the information Based on the provided details")
    public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist){
        String touristDb = iTouristService.updateTourist(tourist);
        return new ResponseEntity<>(touristDb,HttpStatus.OK);
    }

    @DeleteMapping("/deleteTourist/{id}")
    @Operation(summary = "Delete a Tourist",description = "Delete a Tourist from the system based on the id")
    public ResponseEntity<String> deleteTourist(@PathVariable("id") Integer id){
        String touristDb = iTouristService.deleteTourist(id);
        return new ResponseEntity<>(touristDb,HttpStatus.OK);
    }

    @GetMapping("/getTourist/{id}")
    @Operation(summary = "Get Tourist by id",description = "Retieve a Tourist by id in the system")
    public ResponseEntity<String> getTouristById(@PathVariable("id") Integer id){
        String touristDb = iTouristService.getTourist(id);
        return new ResponseEntity<>(touristDb,HttpStatus.OK);
    }

    @GetMapping("/getAllTourist")
    @Operation(summary = "Get All Tourist",description = "Retieve a list of all Tourist in the system")
    public ResponseEntity<List<Tourist>> getAllTourist(){
        List<Tourist> touristDb = iTouristService.getAllTourists();
        return new ResponseEntity<List<Tourist>>(touristDb,HttpStatus.OK);
    }


}
