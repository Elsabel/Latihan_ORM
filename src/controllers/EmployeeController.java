/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import daos.GeneralDao;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import models.Department;
import models.Employee;
import models.Job;
import tools.HibernateUtil;

/**
 *
 * @author DELL
 */
public class EmployeeController <E>{

    private GeneralDao dao;

    public EmployeeController() {

        this.dao = new GeneralDao(HibernateUtil.getSessionFactory());
    }

    public String save(String id, String firstname, String lastname,
            String email, String phone, String hire, String salary,
            String commision, String manager, String job, String department) throws ParseException {
        String startDate = hire;
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(startDate);
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

        return this.dao.save(new Employee(Integer.parseInt(id), firstname,
                lastname, email, phone, sqlStartDate, Integer.parseInt(salary),
               Integer.parseInt(commision), new Employee(Integer.parseInt(manager)),
                new Job(job), new Department(Short.parseShort(department))))
                ? "Success to Create Employee" : "Failed to Create Employee";
    }

//
    public String delete(String id) {
        return this.dao.delete(new Employee(Integer.parseInt(id)))
                ? "Success to Delete Employee" : "Failed to Delete Employee";
    }

    public List<Employee> getAll() {
        return this.dao.select("Employee");
    }

    public List<Employee> search(String cmb, String txt) {
        return this.dao.search("Employee", cmb, txt);
    }
    public Employee selectByName(String fname, String lname) {
        return (Employee) this.dao.selectByField("Employee", "firstName", "lastName", fname, lname);
    }

}


