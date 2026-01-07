package com.cloudcharts.cloudchartsproj.controller;

import com.cloudcharts.cloudchartsproj.entity.AppsVisits;
import com.cloudcharts.cloudchartsproj.entity.Inventory;
import com.cloudcharts.cloudchartsproj.entity.Sales;
import com.cloudcharts.cloudchartsproj.entity.Temperature;
import com.cloudcharts.cloudchartsproj.repository.AppsVisitsRepository;
import com.cloudcharts.cloudchartsproj.repository.InventoryRepository;
import com.cloudcharts.cloudchartsproj.repository.SalesRepository;
import com.cloudcharts.cloudchartsproj.repository.TemperatureRepository;
import com.cloudcharts.cloudchartsproj.dto.NbpRateDto;
import com.cloudcharts.cloudchartsproj.service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/charts")
public class CloudChartsController {

    private final AppsVisitsRepository appsVisitsRepository;
    private final InventoryRepository inventoryRepository;
    private final SalesRepository salesRepository;
    private final TemperatureRepository temperatureRepository;
    private final CurrencyService currencyService;

    public CloudChartsController(AppsVisitsRepository appsVisitsRepository, InventoryRepository inventoryRepository, SalesRepository salesRepository, TemperatureRepository temperatureRepository, CurrencyService currencyService) {
        this.appsVisitsRepository = appsVisitsRepository;
        this.inventoryRepository = inventoryRepository;
        this.salesRepository = salesRepository;
        this.temperatureRepository = temperatureRepository;
        this.currencyService = currencyService;
    }

    @GetMapping("/temperature")
    public List<Temperature> getTemperatures() {
        return temperatureRepository.findAll();
    }

    @GetMapping("/inventory_storage")
    public List<Inventory> inventoryStorage() {
        return inventoryRepository.findAll();
    }

    @GetMapping("/monthly_sales")
    public List<Sales> salesMonthly() {
        return salesRepository.findAll();
    }

    @GetMapping("/app_visits")
    public List<AppsVisits> appsVisits() {
        return appsVisitsRepository.findAll();
    }

    @GetMapping("/currency/usd")
    public List<NbpRateDto> usdRates() {
        return currencyService.getLastRates("usd");
    }

    @GetMapping("/currency/chf")
    public List<NbpRateDto> chfRates() {
        return currencyService.getLastRates("chf");
    }








}
