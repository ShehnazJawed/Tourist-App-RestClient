package com.shehnaz.SwaggerAPI_App.iservice;


import com.shehnaz.SwaggerAPI_App.entity.Tourist;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface ITouristService
{
    public String addTourist(Tourist tourist);
    public String updateTourist(Integer id, Double budget);
    public String updateTourist(Tourist tourist);
    public String deleteTourist(Integer id);
    public String getTourist(Integer id);
    public List<Tourist> getAllTourists();

}
