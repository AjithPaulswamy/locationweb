package com.ajith.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ajith.location.Entity.Location;
import com.ajith.location.services.LocationService;

@Controller
public class LocationController {
	
	@Autowired
	LocationService locationService;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	} 
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("Location")Location location,ModelMap modelMap ) {
		Location savedLocation = locationService.updateLocation(location);
		String msg="Location saved with id : "+savedLocation.getId();
		modelMap.addAttribute("msg", msg);
		return "createLocation";
	}
	
	@RequestMapping("/displayLoc")
	public String displayLocation(ModelMap modelMap) {
		List<Location> allLocation = locationService.getAllLocation();
		modelMap.addAttribute("locations", allLocation);
		return "displayLocation";
	}
}
