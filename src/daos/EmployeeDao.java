package daos;

import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import models.Employee;
import models.Region;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author Elsa
 */
public class EmployeeDao {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public EmployeeDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public boolean createEmployee(Employee emp) {
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        
        try {
            this.session.save(emp);
            this.transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            this.session.close();
        }
        return false;
    }

    public boolean deleteEmployee(Employee emp) {

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.delete(emp);
            this.transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            this.session.close();
        }
        return false;
    }

    public boolean updateEmployee(Employee emp) {

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.update(emp);
            this.transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            this.session.close();
        }
        return false;
    }

    public List<Employee> selectEmployee() {
        List<Employee> employees = new ArrayList<>();
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();

        try {
            employees = session.createQuery("from Employee order by 1").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return employees;
    }

    public Employee selectById(long id) {
        Employee employee = new Employee();
        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            employee = (Employee) session.createQuery("from Employee where employeeId=" + id).uniqueResult();
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return employee;
    }
     public Employee selectByName(String fName,String lName) {
        Employee employee = new Employee();
        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            employee = (Employee) session.createQuery("from Employee where firstName='" +fName+"' and lastName='"+lName+"'").uniqueResult();
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return employee;
    }

    public List<Employee> searchEmployees(String key) {
        List<Employee> employees = new ArrayList<>();

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            employees = session.createQuery("from Employee where employeeId like '%" + key
                    + "%' or firstName like '%" + key
                    + "%' or lastName like '%" + key
                    + "%' or email like '%" + key
                    + "%' or phoneNumber like '%" + key
                    + "%' or hireDate like '%" + key
                    + "%' or salary like '%" + key
                    + "%' or commissionPct like '%" + key
                    + "%' or departmentId.departmentName like '%" + key
                    + "%' or managerId.firstName like '%" + key
                    + "%' or jobId.jobTitle like '%" + key + "%'").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return employees;
    }

}
