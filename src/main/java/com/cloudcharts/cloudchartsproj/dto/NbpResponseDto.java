package com.cloudcharts.cloudchartsproj.dto;

import java.util.List;

public class NbpResponseDto {

    private String currency;
    private String code;
    private List<NbpRateDto> rates;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<NbpRateDto> getRates() {
        return rates;
    }

    public void setRates(List<NbpRateDto> rates) {
        this.rates = rates;
    }
}
