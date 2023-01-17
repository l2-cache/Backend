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

    @ManyToOne
    @JoinColumn(name = "apart_id")
    private ApartEntity apart;

    @OneToMany(mappedBy = "leasableArea")
    private List<TradingHistoryEntity> tradingHistories;

    public void update(ApartEntity apart) {
        this.apart = apart;
    }
}
