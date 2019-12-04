/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JobDao;
import daos.RegionDao;
import java.math.BigDecimal;
import java.util.List;
import models.Job;
import models.Region;

/**
 *
 * @author DELL
 */
public class JobController {

    private JobDao dao;

    public JobController() {
        this.dao = new JobDao();
    }

    public JobController(JobDao dao) {
        this.dao = dao;
    }

    public String create(String id, String name, Integer min, Integer max) {
        return this.dao.createJob(new Job(id, name, min, max)) ? 
                "Success to Create Job" : "Failed to Create Job";
    }
    
    public String update(String id, String name,Integer min, Integer max){
        return this.dao.updateJob(new Job(id, name, min, max)) ?
                "Success to Update Job" : "Failed to Update Job";
    }

    public String delete(String id, String name, Integer min, Integer max){
        return this.dao.deleteJob(new Job(id, name, min, max)) ?
                "Success to Delete Job" : "Failed to Delete Job";
    }
    
    public List<Job> getAll(){
     return this.dao.selectJob();
    }
    
    public Job selectById(String id){
        return this.dao.selectById(id);
               
    }
    
    public Job selectByName(String name){
        return this.dao.selectByName(name);     
    }
    
    public List<Job> search(String key){
        return this.dao.searchJob(key);
    }

}
