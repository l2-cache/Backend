package com.sanhak.l2cache.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApartAddress {
    private Long id;
    private String apartName;
    private String city;
    private String dong;
    private String streetAddress;
    private Double latitude;
    private Double longitude;
}
