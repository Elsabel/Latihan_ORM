/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.LocationDao;
import java.math.BigDecimal;
import java.util.List;
import models.Country;
import models.Location;

/**
 *
 * @author Rizky
 */
public class LocationController {
    LocationDao locationDao;

    public LocationController() {
        this.locationDao = new LocationDao();
        
    }

    public LocationController(LocationDao locationDao) {
        this.locationDao = locationDao;
    }
    
    public List<Location> getAll(){
     return this.locationDao.selectLocations();
    }
    
    public String create(String id, String address, String postal, String city,
        String province, String country){
        return this.locationDao.createLocation(new Location(new BigDecimal(id), 
                address, postal, city, province, new Country(country))) ? 
                "Success to Create Location" : "Failed to Create Location";
    }
    public String update(String id, String address, String postal, String city,
        String province, String country){
        return this.locationDao.updateLocation(new Location(new BigDecimal(id), 
                address, postal, city, province, new Country(country))) ? 
                "Success to Update Location" : "Failed to Update Location";
    }
    public String delete(String id){
        return this.locationDao.deleteLocation(new Location(new BigDecimal(id))) ?
                "Success to Delete Location" : "Failed to Delete Location";
    }
    
    public List<Location> search(String key){
        return this.locationDao.searchLocations(key);
    }
    
    public Location selectById(String id){
        return this.locationDao.selectById(Integer.parseInt(id));
    }
    
    public Location selectByName(String name){
        return this.locationDao.selectByName(name);
    }
    
}
