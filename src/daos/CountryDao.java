/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import models.Country;
//import models.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author Rizky
 */
public class CountryDao {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public CountryDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Country> selectCountries() {
        List<Country> countries = new ArrayList<>();
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        try {
            countries = this.session.createQuery("FROM Country").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return countries;
    }

    public Country selectByName(String name) {
        Country countries = new Country();
        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            countries = (Country) session.createQuery("FROM Country WHERE countryName="
                    + "'" + name + "'").uniqueResult();
//            + "countryName like '%" + name + "%'").uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return countries;
    }

//    public List<Country> selectByName(String name) {
//        List<Country> countries = new ArrayList<>();
//        try {
//            this.session = this.sessionFactory.openSession();
//            this.transaction = this.session.beginTransaction();
//            countries = session.createQuery("FROM Country WHERE "
//                    + "countryName like '%" + name + "%'").list();
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            session.close();
//        }
//        return countries;
//    }
}
