/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import daos.GeneralDao;
import java.math.BigDecimal;
import java.util.List;
import models.Job;

import tools.HibernateUtil;

/**
 *
 * @author DELL
 */
public class JobController<E> {

    private GeneralDao dao;

    public JobController() {

        this.dao = new GeneralDao(HibernateUtil.getSessionFactory());
    }

    public String save(String id, String name, Integer min, Integer max) {
        return this.dao.save(new Job(id, name, min, max))
                ? "Success to Save Job" : "Failed to Save Job";
    }

//
   public String delete(String id, String name, Integer min, Integer max) {
        return this.dao.delete(new Job(id, name, min, max))
                ? "Success to Delete Job" : "Failed to Delete Job";
    }

    public List<Job> getAll() {
        return this.dao.select("Job");
    }

    public List<Job> search(String cmb, String txt) {
        return this.dao.search("Job", cmb, txt);
    }
     public Job selectByName( String lname) {
        return (Job) this.dao.selectByField("Job", "jobTitle", lname);
    }

 
    

}
