/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDao;
import java.math.BigDecimal;
import java.util.List;
import models.Department;
import models.Employee;
import models.Location;

/**
 *
 * @author HP
 */
public class DepartmentController {

    private DepartmentDao dao;

    public DepartmentController() {
        this.dao = new DepartmentDao();
    }

    public DepartmentController(DepartmentDao dao) {
        this.dao = dao;
    }

    public String create(String id, String name, String manid, String locid) {
        return this.dao.createDepartment(new Department(new Short(id), name, new Employee(new Integer(manid)), new Location(new BigDecimal(locid))))
                ? "Success to Create Department" : "Failed to Create Department";
    }

    public String update(String id, String name, String manid, String locid) {
        return this.dao.updateDepartment(new Department(new Short(id), name, new Employee(new Integer(manid)), new Location(new BigDecimal(locid))))
                ? "Success to Update Department" : "Failed to Update Department";
    }

    public String delete(String id) {
        return this.dao.deleteDepartment(new Department(new Short(id)))
                ? "Success to Delete Department" : "Failed to Delete Department";

    }

    public List<Department> getAll() {

        return this.dao.selectDepartments();
    }

    public Department selectById(String id) {

        return this.dao.selectById(Integer.parseInt(id));
    }
    
    public Department selectByName(String name) {
        return this.dao.selectByName(name);
    }
    
    public List<Department> selectByNames(String names){
        return this.dao.selectByNames(names);
    }

    public List<Department> search(String key) {

        return this.dao.searchDepartments(key);
    }

}
