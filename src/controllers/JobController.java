/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDao;
import java.util.List;
import models.Job;
import tools.HibernateUtil;

/**
 *
 * @author DELL
 */
public class JobController {

   private GeneralDao dao;
   
    public JobController() {
        this.dao = new GeneralDao(HibernateUtil.getSessionFactory());
    }
//    private void bindingTabels(JTable table, String[] header, List<Object> datas) {
//        DefaultTableModel model = new DefaultTableModel(header, 0);
//
//        for (Object data : datas) {
//            Job jobs = (Job) data;
//            Object[] data1 = {
//                jobs.getJobId(),
//                jobs.getJobTitle(),
//                jobs.getMinSalary(),
//                jobs.getMaxSalary()
//            };
//            model.addRow(data1);
//        }
//        table.setModel(model);
//    }
//
//    public void bindingall(JTable table, String[] header) {
//        bindingTabels(table, header, jd.select());
//    }

    public String create(String id, String name, Integer min, Integer max) {
        return this.dao.save(new Job(id, name, min, max))
                ? "Success to Save Job" : "Failed to Save Job";
    }

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
}
