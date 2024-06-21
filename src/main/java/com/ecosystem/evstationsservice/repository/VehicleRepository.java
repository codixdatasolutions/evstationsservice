package com.ecosystem.evstationsservice.repository;

import com.ecosystem.evstationsservice.model.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicles,Integer> {
}
