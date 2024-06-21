package com.ecosystem.evstationsservice.repository;

import com.ecosystem.evstationsservice.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {
    @Query("SELECT h FROM History h ORDER BY h.addedon DESC")
    List<History> findAllOrderByAddedOnDesc();

}
