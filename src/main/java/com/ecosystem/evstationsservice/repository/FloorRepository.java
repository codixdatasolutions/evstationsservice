package com.ecosystem.evstationsservice.repository;

import com.ecosystem.evstationsservice.model.Floors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<Floors,Integer> {
}
