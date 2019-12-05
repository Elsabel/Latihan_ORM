/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import tools.HibernateUtil;

/**
 *
 * @author Elsa
 */
public class JobDao {

    public GeneralDao fd;

    public JobDao() {
        this.fd = new GeneralDao(HibernateUtil.getSessionFactory());
    }

    public List<Object> select() {
        return fd.select("Job");
    }

    public boolean createJob(Object object) {
        return fd.save(object);
    }

    public boolean deleteJob(Object object) {

        return fd.delete(object);
    }

    public boolean updateJob(Object object) {
        return fd.save(object);
    }

    public Object selectById(String id) {
        return fd.selectById("FEOM Job WHERE jobId='" + id + "'");
    }

    public List<Object> searchJob(String key) {
        return fd.select("FROM Job WHERE jobId" + " LIKE '%" + key + "%' jobTitle" + " LIKE '%" + key + "% minSalary" + " LIKE '%" + key + "% maxSalary" + " LIKE '%" + key + "%'");
    }

    public Object selectByName(String name) {
        return fd.selectById("FROM Job WHERE jobTitle='" + name + "'");
    }  
}
