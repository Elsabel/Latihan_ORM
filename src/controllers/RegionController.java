/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import models.Region;
import tools.HibernateUtil;

/**
 *
 * @author DELL
 */
public class RegionController<E> {

    private GeneralDao dao;

    public RegionController() {
        this.dao = new GeneralDao(HibernateUtil.getSessionFactory());
    }

    public RegionController(GeneralDao dao) {
        this.dao = dao;
    }

    public String save(String id, String name) {
      
        dao.save1(new Region(new BigDecimal(id), name));
        String a="Sukses";
        return  a;
       // return this.dao.save1(new Region(new BigDecimal(id), name)) ? 
            //    "Success to Save Region" : "Failed to Save Region";
       
    }
    

    public String delete(String id){
         dao.delete1(new Region(new BigDecimal(id)));
        String a="Sukses";
        return  a;
//        return this.dao.delete(new Region(new BigDecimal(id))) ?
//                "Success to Delete Region" : "Failed to Delete Region";
    }
    
    public List<Region> getAll(){
     return this.dao.select1("Region ");
    }
    public List<Region> search(String field, String key){
     return this.dao.search("Region", field, key);
    }
    
    public Region selectById(String id){
        return (Region) this.dao.selectByField(" Region "," regionId ", id);
    }
    public Region selectByName(String name){
        return (Region) this.dao.selectByField(" Region "," regionName ", name);
    }
    
//    public Region selectByname(String name){
//        return this.dao.selectByName(name);     
//    }
//    public List<Region> search(String key){
//        return this.dao.searchRegions(key);
//    }

}
