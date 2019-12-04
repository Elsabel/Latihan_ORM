/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDao;
import java.math.BigDecimal;
import java.util.List;
import models.Region;

/**
 *
 * @author DELL
 */
public class RegionController {

    private RegionDao dao;

    public RegionController() {
        this.dao = new RegionDao();
    }

    public RegionController(RegionDao dao) {
        this.dao = dao;
    }

    public String create(String id, String name) {
        return this.dao.createRegion(new Region(new BigDecimal(id), name)) ? 
                "Success to Create Region" : "Failed to Create Region";
    }
    
    public String update(String id, String name){
        return this.dao.updateRegion(new Region(new BigDecimal(id), name)) ?
                "Success to Update Region" : "Failed to Update Region";
    }

    public String delete(String id){
        return this.dao.deleteRegion(new Region(new BigDecimal(id))) ?
                "Success to Delete Region" : "Failed to Delete Region";
    }
    
    public List<Region> getAll(){
     return this.dao.selectRegions();
    }
    
    public Region selectById(String id){
        return this.dao.selectById(id);
               
    }
    public List<Region> search(String key){
        return this.dao.searchRegions(key);
    }

}
