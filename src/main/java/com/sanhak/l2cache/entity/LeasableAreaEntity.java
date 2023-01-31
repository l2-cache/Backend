package com.sanhak.l2cache.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "leasable_area")
public class LeasableAreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "leasable_area")
    private Double leasableArea;

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

    @Column(name = "profit")
    private Double profit;

    @ManyToOne
    @JoinColumn(name = "apart_id")
    private ApartEntity apart;

    @OneToMany(mappedBy = "leasableArea" , fetch = FetchType.LAZY)
    private List<TradingHistoryEntity> tradingHistories;

    public void update(ApartEntity apart) {
        this.apart = apart;
    }
}
