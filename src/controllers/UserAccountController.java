/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDao;
import java.util.List;
import models.UserAccount;
import tools.BCrypt;
import tools.HibernateUtil;

/**
 *
 * @author ASUS
 */
public class UserAccountController<E> {

    private GeneralDao dao;

    public UserAccountController() {
        this.dao = new GeneralDao(HibernateUtil.getSessionFactory());
    }

    public UserAccountController(GeneralDao dao) {
        this.dao = dao;
    }

    public boolean login(String key, String password) {
        UserAccount account = (UserAccount) this.dao.selectByField("UserAccount", "username", key);
        if (BCrypt.checkpw(password, account.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public String save(int id, String name, String password) {
        dao.save(new UserAccount(id, name, BCrypt.hashpw(password, BCrypt.gensalt(5))));
        String a = "Login Sukses";
        return a;
    }

    public int max() {
        if (dao.getNewId("UserAccount", "id") == null) {
            int id = 1;
            return id;
        } else {

            String a = "" + dao.getNewId("UserAccount", "id") + "";
            int max = Integer.parseInt(a);
            int newId = max + 1;

            return newId;

        }}
        public List<UserAccount> getAll(){
     return this.dao.select("UserAccount");
    }
        
         public boolean selectByName(String key){
        UserAccount account = (UserAccount) this.dao.selectByField("UserAccount", "username", key);
             if (account==null) {
                 
                 return  true;
             }
             else{
                 return false;
             }
    }
    

}
