/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import models.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author Rizky
 */
public class LocationDao {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public LocationDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Location> selectLocations() {
        List<Location> locations = new ArrayList<>();
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        try {
            locations = this.session.createQuery("FROM Location").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return locations;
    }

    public boolean createLocation(Location location) {
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        try {
            this.session.save(location);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }

    public boolean updateLocation(Location location) {
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        try {
            this.session.update(location);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }

    public boolean deleteLocation(Location location) {
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        try {
            this.session.delete(location);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }

    public List<Location> searchLocations(String key) {
        List<Location> locations = new ArrayList<>();
        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            locations = session.createQuery("FROM Location WHERE locationId "
                    + "like '%" + key + "%' or streetAddress like '%" + key + "%' or postalCode "
                    + "like '%" + key + "%' or city like '%" + key + "%' or stateProvince "
                    + "like '%" + key + "%' or countryId.countryName like '%" + key + "%'").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            } 
        } finally {
            session.close();
        }
        return locations;
    }

    public Location selectById(int id) {
        Location locations = new Location();
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        try {
            locations = (Location) session.createQuery("FROM Location WHERE "
                    + "locationId = " + id).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return locations;
    }

    public Location selectByName(String name) {
        Location locations = new Location();
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        try {
            locations = (Location) session.createQuery("FROM Location WHERE "
                    + "city = '" + name + "'").uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return locations;
    }

}
