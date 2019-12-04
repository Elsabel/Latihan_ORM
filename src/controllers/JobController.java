/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JobDao;
import java.util.List;
import models.Job;

/**
 *
 * @author USER
 */
public class JobController {

    private JobDao dao;

    public JobController() {
        this.dao = new JobDao();
    }

    public JobController(JobDao dao) {
        this.dao = dao;
    }

    public String create(String id, String title, String min, String max) {
        return this.dao.createJob(new Job (id, title, Integer.parseInt(min), Integer.parseInt(max)))
                ? "Success to Create Jobs\n" : "Failed to Create Jobs\n";
    }
    
     public String update(String id, String title, String min, String max){
        return this.dao.updateJob(new Job (id, title, Integer.parseInt(min), Integer.parseInt(max)))
             ? "Success to Update Jobs\n" : "Failed to Update Jobs\n";
    }
    public String delete(String id){
        return this.dao.deleteJob(new Job(id)) ?
                "Success to Delete Jobs\n" : "Failed to Delete Jobs\n";
    }
    
    /**
     *
     * @return
     */
    public List<Job> getAll(){
     return this.dao.selectJobs();
    }
    
    public Job selectById(String id){
        return this.dao.selectById(id);
               
    }
    public Job selectByName(String name){
        return this.dao.selectByName(name);
               
    }
    public List<Job> searchJob(String key){
        return this.dao.searchJob(key);
    }
}
