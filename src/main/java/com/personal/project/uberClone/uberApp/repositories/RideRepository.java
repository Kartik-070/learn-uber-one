package com.personal.project.uberClone.uberApp.repositories;

import com.personal.project.uberClone.uberApp.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
}
