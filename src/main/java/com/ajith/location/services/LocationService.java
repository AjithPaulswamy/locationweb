package com.ajith.location.services;

import java.util.List;

import com.ajith.location.Entity.Location;


public interface LocationService {
	Location saveLocation(Location updatedLocation);

	Location updateLocation(Location updatedLocation);

	void deleteLocation(Location location);

	Location getLocationById(Long id);

	List<Location> getAllLocation();
}
