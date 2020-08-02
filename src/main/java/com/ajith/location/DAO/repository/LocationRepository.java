package com.ajith.location.DAO.repository;

import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ajith.location.Entity.Location;

public interface LocationRepository extends JpaRepository<Location,Long> {
	
	@Query("select type,count(type) from Location group by type")
	public List<Object[]> findTypeAndTypeCount();
}
