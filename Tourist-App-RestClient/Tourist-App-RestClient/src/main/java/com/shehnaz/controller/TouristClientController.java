package com.shehnaz.controller;

import com.shehnaz.service.TouristClientService;
import com.shehnaz.dto.Tourist;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/tourist")
@CrossOrigin(origins ="http://localhost:8080" ) // react Application URL
public class TouristClientController {
    private TouristClientService touristClientService;

    public TouristClientController(TouristClientService touristClientService) {
        this.touristClientService = touristClientService;
    }

    @PostMapping("/register")
    public String register(@RequestBody Tourist tourist){
        return touristClientService.registerTourist(tourist);
    }

    @GetMapping("/{id}")
    public Tourist getTourist(@PathVariable Integer id){
        return touristClientService.getTourist(id);
    }

    @GetMapping("/all")
    public List<Tourist> getAllTourists(){
        return touristClientService.getAllTourists();
    }
    @DeleteMapping("{id}")
    public String deleteTourist(@PathVariable Integer id){
        return touristClientService.deleteTourist(id);
    }

    @PutMapping
    public String updateTourist(@RequestBody Tourist tourist){
        return touristClientService.updateTourist(tourist);
    }

    @PatchMapping("/{id}/{budget}")
    public String updateBudget(@PathVariable Integer id, @PathVariable Double budget){
        return touristClientService.updateBudget(id,budget);
    }






}
