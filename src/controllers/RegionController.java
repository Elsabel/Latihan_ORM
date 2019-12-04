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
//        String message="Failed to Create Region";
//        Region region = new Region();
//        int ids = Integer.parseInt(id);
//        region.setId(ids);
//        region.setName("apa");
//        if (this.dao.createRegion(new Region(Integer.parseInt(id), name))){
//            message="Success to Create Region";
//        }
//        return message;
        return this.dao.createRegion(new Region(new BigDecimal(id), name)) ? 
                "Success to Create Region" : "Failed to Create Region";
    }
    
    public String update(String id, String name){
        return this.dao.updateRegion(new Region(new BigDecimal(id), name)) ?
                "Success to Update Region" : "Failed to Update Region";
    }
//     public String update(Region r){
//        return this.dao.updateRegion(new Region(r.getId(), r.getName())) ?
//                "Success to Update Region" : "Failed to Update Region";
//    }
    public String delete(String id){
        return this.dao.deleteRegion(new Region(new BigDecimal(id))) ?
                "Success to Delete Region" : "Failed to Delete Region";
    }
    
    public List<Region> getAll(){
     return this.dao.selectRegions();
    }
    
    public Region selectById(String id){
        return this.dao.selectById(Integer.parseInt(id));      
    }
    
    public Region selectByName(String name){
        return this.dao.selectByName(name);      
    }
    
    public List<Region> search(String key){
        return this.dao.searchRegions(key);
    }

}
