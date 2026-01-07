package com.cloudcharts.cloudchartsproj.service;

import com.cloudcharts.cloudchartsproj.dto.NbpRateDto;
import com.cloudcharts.cloudchartsproj.dto.NbpResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CurrencyService {

    private final RestTemplate restTemplate;

    public CurrencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<NbpRateDto> getLastRates(String currencyCode) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/"
                + currencyCode + "/last/20/?format=json";

        NbpResponseDto response =
                restTemplate.getForObject(url, NbpResponseDto.class);

        return response.getRates();
    }
}