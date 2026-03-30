package com.personal.project.uberClone.uberApp.repositories;

import com.personal.project.uberClone.uberApp.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
}
