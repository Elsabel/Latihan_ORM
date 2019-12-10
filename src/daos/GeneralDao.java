/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author USER
 */
public class GeneralDao<E> implements IDao<E> {

    private Session session;
    private Transaction transaction;
    private SessionFactory sessionFactory;
    public GeneralDao fd;

    public GeneralDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean save(E entity) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return false;
        

    }
    
     public E save1(E entity) {
     return Execute(entity, null, "SaveOrUpdate",null);
     }

    @Override
    public boolean delete(E entity) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return false;
      
    }
    public E delete1(E entity) {
          return Execute(entity, null, "Delete",null);
    }

    @Override
    public List<E> select(String entity) {
        List<E> data = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            data = session
                    .createQuery("from " + entity + " order by 1")
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
     public List<E> select1(String entity) {
         return  (List<E>) Execute((E) entity, null, "Select",null);
     }

    @Override
    public List<E> search(String tabel, String field, String key) {
        List<E> data = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            data = session.createQuery("from " + tabel + " where " + field + "  like :keys")
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

    @Override
    public E selectByField(String tabel, String field1, String field2, String fname, String lname) {
        E entity = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String query = "from " + tabel + " where " + field1 + "  like :keys and " + field2 + " like :keyss";
            entity = (E) session.createQuery(query)
                    .setString("keys", fname)
                    .setString("keyss", lname)
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
    public E selectByField(String table, String field, String key) {
        E entity = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            entity = (E) session.createQuery("from " + table + " where " + field + " like :key")
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

    public E Execute(E entity, String query, String fungsi,  List<E> data ) {
      
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (fungsi.equals("SaveOrUpdate")) {
                session.saveOrUpdate(entity);
            } else if (fungsi.equals("Delete")) {
                session.delete(entity);
            }
            else if(fungsi.equals("Select")){
             data= new ArrayList<>();
                data = session
                    .createQuery("from " + entity + " order by 1")
                    .list();
            }
            else if(fungsi.equals("Search")){
                
            }

            transaction.commit();
           // return true;
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
    public Object getNewId(String table, String field) {
        return execute(null, null, "Max", table, field, null, null, null);

    }

    public E execute(E entity, String query, String fungsi, String tabel, String field, String key, String field2, String key2) {

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (fungsi.equals("SaveOrUpdate")) {
                session.saveOrUpdate(entity);
            } else if (fungsi.equals("Delete")) {
                session.delete(entity);
            } else if (fungsi.equals("Select")) {
                return (E) session
                        .createQuery("from " + entity + " order by 1")
                        .list();
            } else if (fungsi.equals("Search")) {
                return (E) session.createQuery("from " + tabel + " where " + field + "  like :keys")
                        .setString("keys", "%" + key + "%")
                        .list();
            } else if ((fungsi.equals("SelectByField"))) {
                return (E) session.createQuery("from " + tabel + " where " + field + " like :key")
                        .setString("key", key)
                        .uniqueResult();
            } else if ((fungsi.equals("Max"))) {
                 return (E) session.createQuery("select max("+field+") from "+tabel+"").uniqueResult()
                       ;

            } else if ((fungsi.equals("SelectByField2"))) {
                return (E) session.createQuery("from " + tabel + " where " + field + "  like :key and " + field2 + " like :keys")
                        .setString("key", key)
                        .setString("keys", key2)
                        .uniqueResult();
            }

            transaction.commit();
            // return true;
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


}
