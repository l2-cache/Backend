package com.sanhak.l2cache.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "trading_history")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class TradingHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contract_price")
    private Integer contractPrice;

    @Column(name = "contract_date")
    private LocalDate contractDate;

    @ManyToOne
    @JoinColumn(name = "apart_id")
    private ApartEntity apart;

    @ManyToOne
    @JoinColumn(name = "leasable_area_id")
    private LeasableAreaEntity leasableArea;

    public void updateApart(ApartEntity apart) {
        this.apart = apart;
    }
}
