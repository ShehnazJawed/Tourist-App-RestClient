package com.shehnaz.service;

import com.shehnaz.dto.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TouristClientService {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL="localhost:8080/tourist";

    public  String registerTourist(Tourist tourist){
        ResponseEntity<String> response = restTemplate.postForEntity(BASE_URL + "/register", tourist, String.class);
        return response.getBody();
    }

    public Tourist getTourist(Integer id){
        return restTemplate.getForObject(BASE_URL+"/getTourist/"+id, Tourist.class);
    }

    public List<Tourist> getAllTourists(){
        ResponseEntity<List> response = restTemplate.getForEntity(BASE_URL + "/getAllTourist", List.class);
        return response.getBody();
    }

    public String deleteTourist(Integer id){
//        Object response = restTemplate.delete(BASE_URL + "/deleteTourist/" + id);
//        return "Deleted Successfully for Client App";
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL + "/deleteTourist/" + id, HttpMethod.DELETE, null, String.class);
        return response.getBody();

    }
    public  String updateTourist(Tourist tourist){
        restTemplate.put(BASE_URL+"/updateTourist",tourist,String.class);
        return "Update Successfully from Client App";
    }

    public String updateBudget(Integer id,Double budget){
        restTemplate.patchForObject(BASE_URL+"/updateTourist/"+id+"/"+budget,null,String.class);
        return "Budget updated Successfully From Class App";
    }
}
