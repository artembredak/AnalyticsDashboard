package com.cloudcharts.cloudchartsproj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // ✅
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class CloudChartsControllerScenarioTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAppVisitsBySource() throws Exception {
        mockMvc.perform(get("/api/charts/app_visits")
                        .param("source", "google"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].sourceName").value("Google"))
                .andExpect(jsonPath("$[0].percentage").value(27));
    }

    @Test
    void testWeeklyTemperature() throws Exception {
        mockMvc.perform(get("/api/charts/temperature")
                        .param("day", "Monday"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dayOfTheWeek").value("Monday"))
                .andExpect(jsonPath("$[0].temperature").value(10));
    }

    @Test
    void testMonthlySales() throws Exception {
        mockMvc.perform(get("/api/charts/monthly_sales")
                        .param("month", "January"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].month").value("January"))
                .andExpect(jsonPath("$[0].salesPln").value(120));
    }

    @Test
    void testInventoryStorage() throws Exception {
        mockMvc.perform(get("/api/charts/inventory_storage")
                        .param("product", "Monitor"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[2].productName").value("Monitor"))
                .andExpect(jsonPath("$[2].percentage").value(18.4));
    }
}
