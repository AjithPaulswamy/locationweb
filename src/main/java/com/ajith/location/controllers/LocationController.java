package com.ajith.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ajith.location.DAO.repository.LocationRepository;
import com.ajith.location.Entity.Location;
import com.ajith.location.services.LocationService;
import com.ajith.location.utility.EmailUtility;
import com.ajith.location.utility.ReportUtility;

@Controller
public class LocationController {
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	EmailUtility emailUtility;
	
	@Autowired
	ReportUtility reportUtility;
	
	@Autowired
	LocationRepository locRepo;
	
	@Autowired
	ServletContext sc;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	} 
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("Location")Location location,ModelMap modelMap ) {
		Location savedLocation = locationService.updateLocation(location);
		String msg="Location saved with id : "+savedLocation.getId();
		modelMap.addAttribute("msg", msg);
		emailUtility.sendEmail("springjava90@gmail.com", "Location Saved Forid check message body", msg);
		return "createLocation";
	}
	
	@RequestMapping("/displayLoc")
	public String displayLocation(ModelMap modelMap) {
		List<Location> allLocation = locationService.getAllLocation();
		modelMap.addAttribute("locations", allLocation);
		return "displayLocation";
	}
	
	@RequestMapping("/deleteLoc")
	public String deleteLocation(@RequestParam("id") Long id,ModelMap modelMap) {
		Location loc =new Location();
		loc.setId(id);
		locationService.deleteLocation(loc);
		
		//Duplicate code - adding extra DB call - Avoid this by using session or maintain the list in UI
		List<Location> allLocation = locationService.getAllLocation();
		modelMap.addAttribute("locations", allLocation);
		
		return "displayLocation";
	}
	
	@RequestMapping("/editLoc")
	public String editLocation(@RequestParam("id") Long id,ModelMap modelMap) {
		
		Location loc = locationService.getLocationById(id);
		modelMap.addAttribute("location", loc);
		
		return "updateLocation";
	}
	
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("Location")Location location,ModelMap modelMap ) {
		locationService.updateLocation(location);
		
		List<Location> allLocation = locationService.getAllLocation();
		modelMap.addAttribute("locations", allLocation);
		
		return "displayLocation";
	}
	
	@RequestMapping("/showChart")
	public String viewChart() {
		String path = sc.getRealPath("/");
		
		List<Object[]> locationGroupData = locRepo.findTypeAndTypeCount();
		
		/*for (Object[] objects : locationGroupData) {
			System.out.println("Data : "+objects[0].toString()+", "+objects[1].toString());
		}
		System.out.println("Path : "+path);*/
		
		reportUtility.generatePieChart(path, locationGroupData);
		
		return "reportChart";
	}
	
}
