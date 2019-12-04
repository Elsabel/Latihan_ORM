/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.CountryController;
import controllers.LocationController;
import daos.LocationDao;
import java.math.BigDecimal;
import java.util.List;
import models.Country;
import models.Location;

/**
 *
 * @author Rizky
 */
public class LocationTest {

    public static void main(String[] args) {
        LocationDao locationDao = new LocationDao();
        LocationController locationController = new LocationController();
        CountryController countryController = new CountryController();

//        System.out.println(locationController.create("3900", "new", "new", 
//                "new", "new", "US"));
//        System.out.println(locationController.update("3900", "new edit", "new edit", 
//                "new edit", "new edit", "UK"));
//        System.out.println(locationController.delete(3400);
//        Location lsave = new Location();
//        lsave.setLocationId(BigDecimal.valueOf(3700));
//        lsave.setStreetAddress("tempat baru edit");
//        lsave.setPostalCode("safda");
//        lsave.setCity("tempat baru");
//        lsave.setStateProvince("asdklfjsad");
//        lsave.setCountryId(new Country("US"));
//        System.out.println(locationDao.createLocation(lsave));
        for (Location sl : locationController.getAll()) {
            System.out.println("ID=" + sl.getLocationId() + ""
                    + "Address=" + sl.getStreetAddress() + ""
                    + "postal=" + sl.getPostalCode() + "city=" + sl.getCity() + ""
                    + "Province=" + sl.getStateProvince() + ""
                    + "Country=" + sl.getCountryId().getCountryName());
        }
//        System.out.println(locationController.selectById("3900").getLocationId()+ " "
//                + locationController.selectById("3900").getStreetAddress()+ "");
//        
//        System.out.println(locationController.selectByName("Utrecht").getLocationId()+ " "
//                + locationController.selectByName("Utrecht").getStreetAddress());
//        System.out.println(countryController.selectByName("ONE").getCountryName());
//        for (Country country : countryController.selectByName("ONE")) {
//            System.out.println("id " + country.getCountryName());
//        }
//        Location l = new LocationDao().selectById(3400);
//        System.out.println(l.getCountryId().getCountryName());
    }
}
