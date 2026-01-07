package com.cloudcharts.cloudchartsproj.repository;

import com.cloudcharts.cloudchartsproj.entity.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, String> {
}
