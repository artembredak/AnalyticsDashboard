package com.cloudcharts.cloudchartsproj;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CloudChartsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DynamicPropertySource
    static void configureDatasource(DynamicPropertyRegistry registry) {
        Dotenv dotenv = Dotenv.load();
        registry.add("spring.datasource.url", () -> dotenv.get("DB_URL"));
        registry.add("spring.datasource.username", () -> dotenv.get("DB_USERNAME"));
        registry.add("spring.datasource.password", () -> dotenv.get("DB_PASSWORD"));
    }

    // ===================== TEST 1: APP VISITS =====================
    @Test
    void shouldReturnAppVisits() throws Exception {
        mockMvc.perform(get("/api/charts/app_visits"))
                .andExpect(status().isOk());
    }

    // ===================== TEST 2: TEMPERATURE =====================
    @Test
    void shouldReturnTemperatures() throws Exception {
        mockMvc.perform(get("/api/charts/temperature"))
                .andExpect(status().isOk());
    }

    // ===================== TEST 3: MONTHLY SALES =====================
    @Test
    void shouldReturnMonthlySales() throws Exception {
        mockMvc.perform(get("/api/charts/monthly_sales"))
                .andExpect(status().isOk());
    }

    // ===================== TEST 4: INVENTORY =====================
    @Test
    void shouldReturnInventoryStorage() throws Exception {
        mockMvc.perform(get("/api/charts/inventory_storage"))
                .andExpect(status().isOk());
    }
}
