/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
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
public class RegionDao {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public RegionDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public boolean createRegion(Region region) {

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
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

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
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

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
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

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            regions = session.createQuery("from Region").list();
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

    public Region selectById(long id) {
        Region region = new Region();
        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            region=(Region) session.createQuery("from Region where region_id="+id).uniqueResult();
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction!=null) {
                transaction.rollback();
            }
        }
        finally{
            session.close();
        }
        return region;
    }
    public List<Region> searchRegions(String key){
          List<Region> regions = new ArrayList<>();

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            regions = session.createQuery("from Region where regionId like '%"+key+"%' or regionName like '%"+key+"%'").list();
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
    

}
