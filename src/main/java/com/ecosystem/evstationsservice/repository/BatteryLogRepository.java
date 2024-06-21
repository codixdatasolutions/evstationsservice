package com.ecosystem.evstationsservice.repository;

import com.ecosystem.evstationsservice.model.Batteries;

import com.ecosystem.evstationsservice.model.Batterylogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatteryLogRepository  extends JpaRepository<Batterylogs,Integer> {

    @Query("SELECT h FROM Batterylogs h ORDER BY h.swappedTime DESC")
    List<Batterylogs> findAllOrderBYSwappedTimeDesc();
}
