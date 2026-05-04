package com.shehnaz.SwaggerAPI_App.service;

import com.shehnaz.SwaggerAPI_App.entity.Tourist;
import com.shehnaz.SwaggerAPI_App.exception.TouristNotFoundException;
import com.shehnaz.SwaggerAPI_App.iservice.ITouristService;
import com.shehnaz.SwaggerAPI_App.repository.TouristRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristService implements ITouristService {

    @Autowired
    private TouristRepo touristRepo;

    @Override
    public String addTourist(Tourist tourist) {
        Tourist touristDb=touristRepo.save(tourist);
        return "Tourist add successfully for id: "+touristDb.getId();
    }

    @Override
    public String updateTourist(Integer id, Double budget) {
        Optional<Tourist> optional = touristRepo.findById(id);
        if (optional.isPresent()){
            Tourist tourist=optional.get();
            tourist.setBudget(budget);
            touristRepo.save(tourist);
            return "Tourist Budget updated successfully for id: "+id;
        }
        throw new TouristNotFoundException("Tourist Not Found with id: "+id);
    }

    @Override
    public String updateTourist(Tourist tourist) {
        Tourist touristDb=touristRepo.findById(tourist.getId()).orElseThrow(()->new TouristNotFoundException("Tourist Not Found with id: "+tourist.getId()));
        touristDb.setName(tourist.getName());
        touristDb.setCity(tourist.getCity());
        touristDb.setBudget(tourist.getBudget());
        touristDb.setPackageType(tourist.getPackageType());
        touristRepo.save(touristDb);
        return "Tourist Info Save Successfully with id: "+touristDb.getId();
    }

    @Override
    public String deleteTourist(Integer id) {
        Optional<Tourist> tourist=touristRepo.findById(id);
        if (tourist.isPresent()){
            touristRepo.deleteById(id);
            return "Tourist delete Successfully for id:"+id;
        }
        throw new TouristNotFoundException("Tourist Not Found for id: "+id);
    }

    @Override
    public String getTourist(Integer id) {
        Optional<Tourist> optional = touristRepo.findById(id);
        if (optional.isPresent()){
            return "Tourist Info Found For id: "+id;
        }
        throw new TouristNotFoundException("Tourist Not Found for id: "+id);
    }

    @Override
    public List<Tourist> getAllTourists() {
        return touristRepo.findAll();
    }
}
