package com.sanhak.l2cache.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
public class TradingHistory {
    @JsonProperty(value = "x")
    private LocalDate date;

    @JsonProperty(value = "y")
    private Double price;
}
