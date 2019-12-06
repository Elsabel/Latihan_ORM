/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
public class CountryController {

    private GeneralDao dao;

    public CountryController() {
        this.dao = new GeneralDao(HibernateUtil.getSessionFactory());   
    }

    public List<Country> getAll() {
        return this.dao.select("Country");
    }
    
    public Country selectByName(String txt){
        return (Country) this.dao.selectByName("Country", "countryName", txt);
    }
    
}
