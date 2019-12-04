package daos;

import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import models.Department;
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

    public List<Department> selectDepartment() {
        List<Department> departments = new ArrayList<>();

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            departments = session.createQuery("from Department").list();
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

    public Department selectById(String id) {
        Department department = new Department();
        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            department = (Department) session.createQuery("from Department where departmentId=" + id).uniqueResult();
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
    public Department selectByName(String id) {
        Department department = new Department();
        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            department = (Department) session.createQuery("from Department where departmentName='" + id+"'").uniqueResult();
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

    public List<Department> searchDepartment(String key) {
        List<Department> departments = new ArrayList<>();

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            departments = session.createQuery("from Department where departmentId like '%" + key
                    + "%' or departmentName like '%" + key
                    + "%' or managerId like '%" + key
                    + "%' or locationId like '%" + key + "%'").list();
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
