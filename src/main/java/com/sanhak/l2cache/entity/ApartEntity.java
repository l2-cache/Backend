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

    @OneToMany(mappedBy = "apart", fetch = FetchType.LAZY)
    private List<LeasableAreaEntity> leasableAreas;

    @OneToMany(mappedBy = "apart", fetch = FetchType.LAZY)
    private List<TradingHistoryEntity> tradingHistories;
}
