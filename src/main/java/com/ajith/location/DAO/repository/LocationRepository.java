package com.ajith.location.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajith.location.Entity.Location;

public interface LocationRepository extends JpaRepository<Location,Long> {

}
