/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDao;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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

    public String save(String id, String name) {
        return this.dao.save(new Region(new BigDecimal(id), name))
                ? "Success to Save Region" : "Failed to Save Region";
    }

//
    public String delete(String id) {
        return this.dao.delete(new Region(new BigDecimal(id)))
                ? "Success to Delete Region" : "Failed to Delete Region";
    }

    public List<Region> getAll() {
        return this.dao.select("Region");
    }

    public List<Region> search(String cmb, String txt) {
        return this.dao.search("Region", cmb, txt);
    }

}
//    
//    public Region selectById(String id){
//        return this.dao.selectById(Integer.parseInt(id));       
//    }
//    
//    public Region selectByname(String name){
//        return this.dao.selectByName(name);     
//    }
//    public List<Region> search(String key){
//        return this.dao.searchRegions(key);
//    }

