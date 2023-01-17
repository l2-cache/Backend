package com.sanhak.l2cache.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "apart")
public class ApartEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String dong;

    @Column(name = "apart_name")
    private String apartName;

    @Column(name = "street_address")
    private String streetAddress;

    private Double longitude;

    private Double latitude;

    @Column(name = "estimate_two_year_price")
    private Double priceTwoYear;

    @Column(name = "estimate_one_year_price")
    private Double priceOneYear;

    @Column(name = "estimate_half_year_price")
    private Double priceHalfYear;

    @Column(name = "average_monthly_rent_price")
    private Double averageMonthlyRentPrice;

    @Column(name = "average_long_term_rent_price")
    private Double averageLongTermRentPrice;

    @Column(name = "average_monthly_deposit")
    private Double averageMonthlyDeposit;

    @OneToMany(mappedBy = "apart")
    private List<LeasableAreaEntity> leasableAreas;

    @OneToMany(mappedBy = "apart")
    private List<TradingHistoryEntity> tradingHistories;

    public void updateData(Double longTerm, Double monthlyDeposit, Double monthlyPrice, Double estimatePrice) {
        this.averageLongTermRentPrice = longitude;
        this.averageMonthlyDeposit = monthlyDeposit;
        this.averageMonthlyRentPrice = monthlyPrice;
        this.priceTwoYear = estimatePrice;
    }

}
