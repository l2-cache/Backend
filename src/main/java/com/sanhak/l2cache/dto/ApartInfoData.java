package com.sanhak.l2cache.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ApartInfoData {
    private String fullAddress;
    private String apartName;
    private List<Double> netLeasableAreas;
    private List<LeasableArea> tradingHistories;
}
