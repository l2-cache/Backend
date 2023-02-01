package com.sanhak.l2cache.dto;

import lombok.*;

@Getter
@Builder
public class Profit {
    private String address;
    private Integer price;
    private Double leasableArea;
    private Double profit;
}
