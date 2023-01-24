package com.sanhak.l2cache.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class LeasableArea {
    @JsonProperty(value = "data")
    private List<TradingHistory> tradingHistories;
    private String name = "거래가격";
    private Double area;
    private Double priceHalfYear;
    private Double priceOneYear;
    private Double priceTwoYear;
    private Double monthlyDeposit;
    private Double monthlyPrice;
    private Double predictMonthlyDeposit;
    private Double predictMonthlyPrice;
}
