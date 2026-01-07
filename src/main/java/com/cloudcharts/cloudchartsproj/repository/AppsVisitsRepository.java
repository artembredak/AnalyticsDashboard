package com.cloudcharts.cloudchartsproj.repository;

import com.cloudcharts.cloudchartsproj.entity.AppsVisits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppsVisitsRepository extends JpaRepository<AppsVisits, String> {
}
