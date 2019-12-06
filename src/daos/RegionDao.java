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

   private GeneralDao settingDao;

    public RegionDao() {
        this.settingDao = new GeneralDao(HibernateUtil.getSessionFactory());
    }

   

//    @Override
//    public boolean insert(Object object) {
//       return this.settingDao.create(object);
//    }
//
//    @Override
//    public boolean update(Object object) {
//         return this.settingDao.create(object);
//    }
//
//    @Override
//    public boolean delete(Object object) {
//         return this.settingDao.delete(object);
//    }
//
//    @Override
//    public List<Object> select() {
//        return this.settingDao.select("from Region order by 1");
//    }
//
//    @Override
//    public List<Object> search(String search) {
//         return this.settingDao.search("from Region where regionId = '"+ search + "' "
//                 + "OR regionName = '"+ search +"'");
//    }
//
//    @Override
//    public Object selectById(String id) {
//        return this.settingDao.selectById("from Region where regionId = '"+ id +"'");
//    }
//
//    @Override
//    public Object selectByName(String name) {
//     return this.settingDao.selectById("from Region where regionName = '"+ name +"'");
//    }
}
