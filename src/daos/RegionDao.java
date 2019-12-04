/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import models.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author Rizky
 */
public class RegionDao {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public RegionDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public boolean createRegion(Region region) {
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        try {
            this.session.save(region);
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

    public boolean deleteRegion(Region region) {
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        try {
            this.session.delete(region);
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

    public boolean updateRegion(Region region) {
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        try {
            this.session.update(region);
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

    public List<Region> selectRegions() {
        List<Region> regions = new ArrayList<>();
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        try {
            regions = session.createQuery("FROM Region").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return regions;
    }

    public List<Region> searchRegions(String key) {
        List<Region> regions = new ArrayList<>();
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        try {
            regions = session.createQuery("FROM Region WHERE regionId "
                    + "like '%"+key+"%' or regionName like '%"+key+"%'").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return regions;
    }

    public Region selectById(int id) {
        Region r = new Region();
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        try {
            r = (Region) session.createQuery("FROM Region WHERE "
                    + "regionId = "+id).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return r;
    }
    
    public Region selectByName(String name) {
        Region r = new Region();
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        try {
            r = (Region) session.createQuery("FROM Region WHERE "
                    + "regionName = "+name).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return r;
    }

}
