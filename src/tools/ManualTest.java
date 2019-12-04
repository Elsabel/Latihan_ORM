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
import org.hibernate.Session;

/**
 *
 * @author Elsa
 */
public class ManualTest {

    public static void main(String[] args) {
        // System.out.println(HibernateUtil.getSessionFactory());
        //Session session=HibernateUtil.getSessionFactory().openSession();

//        Job job=new Job();
//        job.setjobId("DEV");
//        job.setjobTitle("Developer");
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
//        
//        List<Region> rd=new RegionController().getAll();
//        for (Region region3 : rd) {
//            System.out.println(region3.getRegionId()+" "+region3.getRegionName());
//        }
//        
}
}
