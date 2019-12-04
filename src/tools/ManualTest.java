/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.RegionController;
import daos.RegionDao;
import java.math.BigDecimal;
import java.util.List;
import models.Region;

/**
 *
 * @author Rizky
 */
public class ManualTest {

    public static void main(String[] args) {
//        System.out.println(HibernateUtil.getSessionFactory()); //cek koneksi

//***************TESTING REGION MENGGUNAKAN CONTROLLER****************//
        RegionController regionController = new RegionController(); //ambil region controller dari region controller
        
//        System.out.println(regionController.create("8", "MII")); //create region
//        System.out.println(regionController.update("7", "namanya diubah")); //update region
//        System.out.println(regionController.delete("6")); //delete region
//        System.out.println(regionController.selectById("2").getRegionName());
        System.out.println(regionController.selectByName("Asia").getRegionName());
        
        //select all region
//        for (Region region : regionController.getAll()) {
//            System.out.println("ID = " + region.getRegionId() + ""
//                    + " | Name = " + region.getRegionName());
//        }
        
        //search region
//        for (Region region : regionController.search("si")) {
//            System.out.println("ID = " + region.getRegionId() + ""
//                    + " | Name = " + region.getRegionName());
//        }
        


//***************TESTING REGION MENGGUNAKAN DAO****************//
//        RegionDao regionDao = new RegionDao(); //ambil regiondao dari regiondao
//        Region region = new Region(); //ambil model dari region model
//        region.setRegionId(new BigDecimal(6)); //set id region
//        region.setRegionName("APL TOWER EDIT"); //set nama region
//        System.out.println(regionDao.createRegion(region)); //fungsi create region
//        System.out.println(regionDao.deleteRegion(region)); //fungsi delete region
//        System.out.println(regionDao.updateRegion(region)); //fungsi update region
//        List<Region> regions1 = regionDao.searchRegions("e");
//        System.out.println("Search =");
//        for (Region region1 : regions1) {
//            System.out.println("ID = " + region1.getRegionId() + ""
//                    + " | Name = " + region1.getRegionName());
//        }
//        System.out.println("\n");
//        List<Region> regions = regionDao.selectRegions(); //inisiasi list select all di region dao
//        System.out.println("GET ALL =");
//        for (Region r : regions) { //foreach untuk menampilkan select all/search
//            System.out.println("ID = " + r.getRegionId() + ""
//                    + " | Name = " + r.getRegionName());
//        }
//        //menampilkan data region sesuai id yang diinputkan
//        System.out.println(regionDao.selectById(4).getRegionName() + " "
//                + regionDao.selectById(4).getRegionId());



    }
}
