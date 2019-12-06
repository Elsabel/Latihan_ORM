/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDao;
import java.math.BigDecimal;
import java.util.List;
import models.Department;
import models.Employee;
import models.Location;
import tools.HibernateUtil;

/**
 *
 * @author HP
 */
public class DepartmentController<E> {

    private GeneralDao dao;

    public DepartmentController() {
        this.dao = new GeneralDao(HibernateUtil.getSessionFactory());
    }

//    public DepartmentController(DepartmentDao dao) {
//        this.dao = dao;
//    }
    public String save(String id, String name, String manid, String locid) {
        return this.dao.save(new Department(new Short(id), name, new Employee(new Integer(manid)), new Location(new BigDecimal(locid))))
                ? "Success to Save Department" : "Failed to Save Department";
    }

//    public String update(String id, String name, String manid, String locid) {
//        return this.dao.updateDepartment(new Department(new Short(id), name, new Employee(new Integer(manid)), new Location(new BigDecimal(locid))))
//                ? "Success to Update Department" : "Failed to Update Department";
//    }
    public String delete(String id) {
        return this.dao.delete(new Department(new Short(id)))
                ? "Success to Delete Department" : "Failed to Delete Department";
    }

    public List<Department> getAll() {
        return this.dao.select("Department");
    }

//    public Department selectById(String id) {
//
//        return this.dao.selectById("");
//    }
//    public Department selectByName(String name) {
//        return this.dao.selectByName(name);
//    }
//    public List<Department> selectByNames(String names) {
//        return this.dao.selectByNames(names);
//    }
    public List<Department> search(String tabel, String cmb, String key) {
        return this.dao.search("Department", cmb, key);
    }
    public Department selectById(String txt){
        return (Department) this.dao.selectByName("Location", "locationId", txt);
    }

}
