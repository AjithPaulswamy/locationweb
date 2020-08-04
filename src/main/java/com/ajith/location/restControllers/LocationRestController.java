package com.ajith.location.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ajith.location.DAO.repository.LocationRepository;
import com.ajith.location.Entity.Location;

@RestController
public class LocationRestController {

	@Autowired
	LocationRepository locationRepo;
	
	@GetMapping("/locations")
	public List<Location> getLocations() {
		return locationRepo.findAll();
	}
	
	@PostMapping("/createLocation")
	public Location createLocation(@RequestBody Location location) {
		return locationRepo.save(location);
	}
	@PutMapping("/updateLocation")
	public Location updateLocation(@RequestBody Location location) {
		return locationRepo.save(location);
	}
	@DeleteMapping("/deleteLocation")
	public void deleteLocations(@RequestParam("id") Long id){
		//locationRepo.delete(location);
		locationRepo.deleteById(id);
		//return locationRepo.findAll();
	}
}
