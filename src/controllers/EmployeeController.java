/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDao;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import models.Department;
import models.Employee;
import models.Job;

/**
 *
 * @author DELL
 */
public class EmployeeController {

    private EmployeeDao dao;

    public EmployeeController() {
        this.dao = new EmployeeDao();
    }

    public EmployeeController(EmployeeDao dao) {
        this.dao = dao;
    }

    public List<Employee> getAll() {
        return this.dao.selectEmployee();
    }

    public String create(String id, String firstname, String lastname,
            String email, String phone, String hire, String salary,
            String commision, String manager, String job, String department) throws ParseException {


        String startDate = hire;
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(startDate);
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

        return this.dao.createEmployee(new Employee(Integer.parseInt(id), firstname,
                lastname, email, phone, sqlStartDate,new BigDecimal(salary),
                new BigDecimal(commision), new Employee(Integer.parseInt(manager)),
                new Job(job), new Department(Short.parseShort(department))))
                ? "Success to Create Employee" : "Failed to Create Employee";
    }

    public String update(String id, String firstname, String lastname,
            String email, String phone, String hire, String job, String salary,
            String commision, String manager, String department) throws ParseException {

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(hire);
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

         return this.dao.updateEmployee(new Employee(Integer.parseInt(id), firstname,
                lastname, email, phone, sqlStartDate,new BigDecimal(salary),
                new BigDecimal(commision), new Employee(Integer.parseInt(manager)),
                new Job(job), new Department(Short.parseShort(department))))
                ? "Success to updateee Employee" : "Failed to updateee Employee";
    }
//

    public String delete(String id) {
        return this.dao.deleteEmployee(new Employee(Integer.parseInt(id)))
                ? "Success to Delete Employee" : "Failed to Delete Employee Because Data Already Update";
    }
//

    public Employee selectById(String id) {
        return this.dao.selectById(Long.parseLong(id));

    }

    public Employee selectByName(String fname,String lname) {
        return this.dao.selectByName(fname,lname);

    }
//

    public List<Employee> search(String key) {
        return this.dao.searchEmployees(key);
    }

}
