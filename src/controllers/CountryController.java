/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDao;
import java.math.BigDecimal;
import models.Country;
import java.util.List;
import models.Region;

/**
 *
 * @author ASUS
 */
public class CountryController {

    private CountryDao countryDao;

    public CountryController() {
        this.countryDao = new CountryDao();
    }

    public CountryController(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    public String create(String name, String region_id,String id) {
        return countryDao.createCountry(new Country(name, new Region(BigDecimal.valueOf(Long.parseLong(region_id))), id))
                ? "Failed to Create Country" : "Success to Create Country";
    }

    public String update( String name, String region_id,String id) {
        return countryDao.updateCountry(new Country(name, new Region (BigDecimal.valueOf(Long.parseLong(region_id))), id))
                ? "Failed to Update Country" : "Success to Update Country";
    }

    public String delete(String id) {
        return countryDao.deleteCountry(new Country(id)) ?
                 "Failed to Delete Data" : "Success to Delete Data";
    }

    public List<Country> getAll() {
        return countryDao.selectCountrys();
    }
     public Country selectById(String id){
        return this.countryDao.selectById(Long.parseLong(id));
    }
    public List<Country> search(String key){
        return this.countryDao.searchCountry(key);
    }
    
    public Country selectByName(String name){
        return this.countryDao.selectByName(name);
    }

}
