/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDao;
import daos.GeneralDao;
import java.math.BigDecimal;
import java.util.List;
import models.Country;
import models.Region;
import tools.HibernateUtil;

/**
 *
 * @author ASUS
 */
public class CountryController<E> {

    private GeneralDao dao;

    public CountryController() {
        this.dao = new GeneralDao(HibernateUtil.getSessionFactory());
    }

    public CountryController(GeneralDao dao) {
        this.dao = dao;
    }

    public String create(String id, String name, String regionId) {
        return this.dao.save(new Country(id, name, new Region(new BigDecimal(regionId)))) ? 
                "Success to Save Country" : "Failed to Save Country";
    }
    
    public String delete(String id){
        return this.dao.delete(new Country(id)) ?
                "Success to Delete Country" : "Failed to Delete Country";
    }
    
    public List<Country> getAll(){
     return this.dao.select("Country");
    }
    public List<Country> search(String tabel, String field, String key){
     return this.dao.search(tabel, field, key);
    }
    
      public Country selectById(String id){
        return (Country) this.dao.selectByField(" Country "," countryId ", id);
    }
    public Country selectByName(String name){
        return (Country) this.dao.selectByField(" Country "," countryname ", name);
    }

//    public Country selectById(String id) {
//        return this.dao.selectById(id);
//    }
//    public Country selectByName(String name) {
//        return this.dao.selectByName(name);
//    }
    
//    public List<Country> search(String key) {
//        return this.dao.searchRegions(key);
//    }
}
