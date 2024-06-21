package com.ecosystem.evstationsservice.repository;


import com.ecosystem.evstationsservice.model.Batteries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteryReository  extends JpaRepository<Batteries,Integer> {
}
