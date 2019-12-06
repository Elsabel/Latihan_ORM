/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import models.Country;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * <E> itu untuk elemen / spesifikasi dari object nya
 *
 * @author ASUS
 */
public class GeneralDao<E> implements IDao<E> {

    private Session session;
    private Transaction transaction;
    private final SessionFactory sessionFactory;
    private GeneralDao dao;

    public GeneralDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    public boolean create(E entitiy) {
//
//        try {
//            this.session = this.sessionFactory.openSession();
//            this.transaction = this.session.beginTransaction();
//            this.session.saveOrUpdate(entitiy);
//            this.transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            this.session.close();
//        }
//        return false;
//    }

//    public List<E> select(String entity) {
//        List<E> objects = new ArrayList<>();
//        try {
//            this.session = this.sessionFactory.openSession();
//            this.transaction = this.session.beginTransaction();
//            Query sql = session.createQuery("From ?");
//            List result = (List) sql.setString(0, entity);
////            PreparedStatement statement = session.Pre
////            objects = session.createQuery("From "+entity).list();
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            session.close();
//        }
//        return objects;
//    }

    @Override
    public boolean save(E entity) {
        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.saveOrUpdate(entity);
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

    @Override
    public boolean delete(E entity) {
        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.delete(entity);
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

    @Override
    public List<E> select(String entity) {
        List<E> data = new ArrayList<>();
        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            data = session.createQuery("From " + entity + " order by 1").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return data;
    }

    @Override
    public E selectByField(String table, String field, String key) {
        E entity = null;
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        try {
            entity = (E) session.createQuery("from " + table + " where " + field + " = :key ")
                    .setString("key", key)
                    .uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return entity;
    }

    @Override
    public List<E> search(String tabel, String field, String key) {
        List<E> data = new ArrayList<>();
        try {
            this.session = this.sessionFactory.openSession();
            this.transaction = this.session.beginTransaction();
            String sql = "from " + tabel + " where " + field + " like :keys";
            data = session.createQuery(sql)
                    .setString("keys", "%" + key + "%")
                    .list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return data;
    }

}
