/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.GeneralDao;
import java.util.List;
import models.Region;

/**
 *
 * @author Elsa
 */
public class ManualTest {

    public static void main(String[] args) {
        // System.out.println(HibernateUtil.getSessionFactory());
        //Session session=HibernateUtil.getSessionFactory().openSession();

//        Region region=new Region();
//        region.setRegionId(new BigDecimal(13));
//        region.setRegionName("Jekate");
//        RegionDao regiondao=new RegionDao();
        //System.out.println(regiondao.createRegion(region));
        // System.out.println(regiondao.deleteRegion(region));
        //System.out.println(regiondao.updateRegion(region));
        // List<Region> rs=regiondao.selectRegions();
//        for (Region r : rs) {
//            System.out.println("ID : "+r.getRegionId()+
//                    "\nName : "+r.getRegionName());
//        }
//        Region region=new RegionDao().selectById(4);
//        System.out.println(region.getRegionName());
        //SEARCH 
//            List<Region> regions=new RegionDao().searchRegions("2");
//            for (Region region : regions) {
//            Region r=region;
//                System.out.println(r.getRegionName());
//        }
        //GET ALL USE CONTROLLER
//        List<Region> rc=new RegionController().getAll();
//        for (Region region : rc) {
//        System.out.println(region.getRegionId()+" "+region.getRegionName());
//        }
        //CREATE USE CONTROLLER
//        Region region = new Region();
//        RegionController controller = new RegionController();
//        System.out.println(controller.create(6, "Meikartaulalala"));
//        
//        List<Region> rc=new RegionController().getAll();
//        for (Region region1 : rc) {
//            System.out.println(region1.getRegionId()+" "+region1.getRegionName());
//        }
        //UPDATE USE CONTROLLER
//        Region region = new Region();
//        RegionController controller = new RegionController();
//        System.out.println(controller.update(6, "ULALALA"));
//        
//        List<Region> rs=new RegionController().getAll();
//        for (Region region2 : rs) {
//            System.out.println(region2.getRegionId()+" "+region2.getRegionName());
//        }
        //DELETE USE CONTROLLER
//        RegionController regionController=new RegionController();
//        System.out.println(regionController.delete("13"));
//        List<Region> rd=new RegionController().getAll();
//        for (Region region3 : rd) {
//            System.out.println(region3.getRegionId()+" "+region3.getRegionName());
//        }
//        Region region = new Region();
//        System.out.println(regionController.selectById("1").getRegionName());
//        CountryController controller = new CountryController();
//        System.out.println(controller.create("SD", "Meikartaulalala", "1"));
//        Region region = new Region();
//        CountryController countryController = new CountryController();
//        System.out.println(countryController.create("SD", "Meikarta", "1"));
//        System.out.println(controller.delete("SD"));
//        System.out.println(countryController.selectByName("Kuwait").getCountryId());
//        List<Country> rd = new CountryController().getAll();
//        for (Country country : rd) {
//            System.out.println(country.getCountryId() + " " + country.getCountryName() + " " + country.getRegionId().getRegionName());
//        }
//        System.out.println(countryController.selectById("China").getCountryId());
////        List<Country> rd = new CountryController().search("KW");
////        for (Country country : rd) {
////            System.out.println(country.getCountryId() + " " + country.getCountryName() + " " + country.getRegionId().getRegionName());
////        }
        GeneralDao dao = new GeneralDao(HibernateUtil.getSessionFactory());
//        RegionDao regionDao = new RegionDao();
//        Region region = new Region();
//        region.setRegionId(new BigDecimal(10));
//        region.setRegionName("Jafar");
//        dao.save(region);

//        int key = 1;
//        System.out.println(regionDao.selectById("1"));
        List<Region> rs = dao.search("a", "b", "9");
        rs.forEach((r) -> {
            System.out.println("ID : " + r.getRegionId()
                    + "\nName : " + r.getRegionName());
        });//          dao.save(new Region(new BigDecimal(18), "jafar"));
    }
}
