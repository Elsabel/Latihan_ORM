/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import models.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author HP
 */
public class DepartmentDao {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public DepartmentDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public boolean createDepartment(Department department) {

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.save(department);
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

    public boolean deleteDepartment(Department department) {

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.delete(department);
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

    public boolean updateDepartment(Department department) {

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.update(department);
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

    public List<Department> selectDepartments() {
        List<Department> departments = new ArrayList<>();

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            departments = session.createQuery("FROM Department").list();
//            departments = session.createQuery("select d.departmentId, d.departmentName, e.managerId from Department d left join d.employeeId e").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return departments;
    }

    public Department selectById(int id) {
        Department department = new Department();
        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            department = (Department) session.createQuery("FROM Department WHERE departmentId=" + id).uniqueResult();
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return department;
    }

    public Department selectByName(String name) {
        Department department = new Department();
        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            department = (Department) session.createQuery("FROM Department WHERE departmentName = '%" + name + "%'").uniqueResult();
//            department = (Department) session.createQuery("FROM Department WHERE departmentName LIKE '%"+name+"%' "+name).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return department;
    }

    public List<Department> selectByNames(String name) {
        List<Department> departments = new ArrayList<>();
        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
//            departments = session.createQuery("FROM Department WHERE departmentName = "+name).list();
            departments = session.createQuery("FROM Department WHERE departmentName LIKE '%" + name + "%'").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return departments;
    }

    public List<Department> searchDepartments(String key) {
        List<Department> departments = new ArrayList<>();

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            departments = session.createQuery("FROM Department WHERE departmentId "
                    + "LIKE '%" + key + "%' OR departmentName "
                    + "LIKE '%" + key + "%' OR managerId "
                    + "LIKE '%" + key + "%' OR managerId.firstName "
                    + "LIKE '%" + key + "%' OR locationId.city "
                    + "LIKE '%" + key + "%'").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return departments;
    }

}
