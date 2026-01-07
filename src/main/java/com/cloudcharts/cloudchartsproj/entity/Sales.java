package com.cloudcharts.cloudchartsproj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="monthly_sales")
public class Sales {

    @Id
    private String id;

    private String month;
    private int salesPln;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getSalesPln() {
        return salesPln;
    }

    public void setSalesPln(int salesPln) {
        this.salesPln = salesPln;
    }
}
