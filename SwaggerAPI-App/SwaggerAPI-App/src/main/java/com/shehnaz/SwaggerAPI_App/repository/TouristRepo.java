package com.shehnaz.SwaggerAPI_App.repository;

import com.shehnaz.SwaggerAPI_App.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepo extends JpaRepository<Tourist,Integer> {
}
