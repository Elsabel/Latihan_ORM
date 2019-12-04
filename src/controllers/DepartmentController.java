/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDao;
import daos.EmployeeDao;
import daos.LocationDao;
import java.util.List;
import models.Department;
import models.Employee;
import models.Location;
import models.Region;

/**
 *
 * @author HP
 */
public class DepartmentController {

    private DepartmentDao dao;
    private EmployeeDao edao;
    private LocationDao ldao;

    public DepartmentController() {
        this.dao = new DepartmentDao();
        this.edao=new EmployeeDao();
        this.ldao=new LocationDao();
    }

    public DepartmentController(DepartmentDao dao) {
        this.dao = dao;
    }

    public String create(String id, String name, String manid, String locid) {
        return this.dao.createDepartment(new Department(Short.parseShort(id), name, new Employee(Integer.parseInt(manid)), new Location(Short.parseShort(locid))))
                ? "Success to Create Department" : "Failed to Create Department";
    }

    public String update(String id, String name, String manid, String locid) {
        return this.dao.updateDepartment(new Department(Short.parseShort(id), name, new Employee(Integer.parseInt(manid)), new Location(Short.parseShort(locid))))
                ? "Success to Update Department" : "Failed to Update Department";
    }

    public String delete(String id) {
//        return this.dao.deleteDepartment(Integer.parseInt(id))
        return this.dao.deleteDepartment(new Department(Short.parseShort(id)))
                ? "Success to Delete Department" : "Failed to Delete Department";

    }

    public List<Department> getAll() {

        return this.dao.selectDepartment();
    }

    public Department selectById(String id) {

        return this.dao.selectById(id);
    }

    public List<Department> search(String key) {

        return this.dao.searchDepartment(key);
    }

    public Department selectByName(String name) {
        return this.dao.selectByName(name);
}
}
