/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDao;
import java.math.BigDecimal;
import java.util.List;
import models.Country;
import models.Region;

/**
 *
 * @author ASUS
 */
public class CountryController {

    private CountryDao dao;

    public CountryController() {
        this.dao = new CountryDao();
    }

    public CountryController(CountryDao dao) {
        this.dao = dao;
    }

    public String create(String id, String name, String regionId) {
        return this.dao.createCountry(new Country(id, name, new Region(new BigDecimal(regionId))))
                ? "Success to Create Region" : "Failed to Create Region";
    }

    public String update(String id, String name, String regionId) {
        return this.dao.updateCountry(new Country(id, name, new Region(new BigDecimal(regionId))))
                ? "Success to Update Region" : "Failed to Update Region";
    }

    public String delete(String id) {
        return this.dao.deleteCountry(new Country(id))
                ? "Success to Delete Region" : "Failed to Delete Region";
    }

    public List<Country> getAll() {
        return this.dao.selectCountries();
    }

    public Country selectById(String id) {
        return this.dao.selectById(id);
    }
    
    public List<Country> search(String key) {
        return this.dao.searchRegions(key);
    }
}
