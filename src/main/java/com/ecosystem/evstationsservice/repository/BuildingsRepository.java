package com.ecosystem.evstationsservice.repository;

import com.ecosystem.evstationsservice.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingsRepository extends JpaRepository<Building,Integer> {
}
