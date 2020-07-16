package com.ajith.location.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajith.location.DAO.repository.LocationRepository;
import com.ajith.location.Entity.Location;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepo;
	
	@Override
	public Location saveLocation(Location updatedLocation) {
		Location loc=locationRepo.save(updatedLocation);
		return loc;
	}

	@Override
	public Location updateLocation(Location updatedLocation) {
		Location loc=locationRepo.save(updatedLocation);
		return loc;
	}

	@Override
	public void deleteLocation(Location location) {
		locationRepo.delete(location);
		
	}

	@Override
	public Location getLocationById(Long id) {
		Optional<Location> optionalLocation=locationRepo.findById(id);
		if(!optionalLocation.isEmpty()) {
			return optionalLocation.get();
		}
		else {
			return null;
		}
	}

	@Override
	public List<Location> getAllLocation() {
		return locationRepo.findAll();
	}
	
}
