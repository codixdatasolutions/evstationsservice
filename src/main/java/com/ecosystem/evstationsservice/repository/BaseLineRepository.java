package com.ecosystem.evstationsservice.repository;

import com.ecosystem.evstationsservice.model.Baseline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseLineRepository extends JpaRepository<Baseline,Integer> {
}
