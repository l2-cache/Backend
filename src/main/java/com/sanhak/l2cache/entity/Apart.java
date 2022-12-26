package com.sanhak.l2cache.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "apart")
public class Apart {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "road_address")
    private String address;

    @Column(name = "apartment_name")
    private String apartName;

    private String dong;
    private Double latitude;
    private Double longitude;
    private Integer floor;

}
