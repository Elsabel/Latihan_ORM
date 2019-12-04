/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import models.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author ASUS
 */
public class CountryDao {
    private SessionFactory sessionFactory;
    private Transaction transaction;
    private Session session;
    
    static SessionFactory sf = HibernateUtil.getSessionFactory();
    public Session openSession(){
        return sf.openSession();
    }
    public CountryDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
     public boolean createCountry(Country country) {

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.save(country);
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

    public boolean deleteCountry(Country country) {

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.delete(country);
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

    public boolean updateCountry(Country country) {

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.update(country);
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

    public List<Country> selectCountries() {
        List<Country> countrys = new ArrayList<>();
        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            countrys = session.createQuery("from Country order by 1").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return countrys;
    }

    public Country selectById(String id) {
        Country country = new Country();
        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            country= (Country) session.createQuery("from Country where countryId= "+id).uniqueResult();
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
        return country;
    }
//    public Country selectById(String id){
//        Session s = this.openSession();
//        return (Country) s.load(Country.class, id);
//    }
      public Country selectByName(String name) {
        Country country = new Country();
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        try {
            country = (Country) session.createQuery("from Country where countryName = '" + name + "' ").uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return country;
    }
            
    public List<Country> searchRegions(String key){
          List<Country> countrys = new ArrayList<>();

        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            countrys = session.createQuery("from Country where countryId like '%"+key+"%' OR countryName like '%"+key+"%' OR regionId.regionName like '%"+key+"%' ").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return countrys;
    }
    
}
