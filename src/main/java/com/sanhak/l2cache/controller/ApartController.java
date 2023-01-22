package com.sanhak.l2cache.controller;

import com.sanhak.l2cache.dto.ApartAddress;
import com.sanhak.l2cache.dto.ApartInfoData;
import com.sanhak.l2cache.dto.LeasableArea;
import com.sanhak.l2cache.dto.TradingHistory;
import com.sanhak.l2cache.entity.ApartEntity;
import com.sanhak.l2cache.service.ApartService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApartController {

    private final ApartService apartService;

    @GetMapping("/find-all")
    public ResponseEntity<List<ApartEntity>> findAllData() {
        try{
            return ResponseEntity.ok().body(apartService.findAllData());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/find-city")
    public ResponseEntity<List<ApartAddress>> findGuData(@RequestParam String city) {
        if (city.isEmpty()) {
            city = "노원구";
        }

        try {
            return ResponseEntity.ok().body(apartService.findCityAllData(city));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("apart-info")
    public ResponseEntity<ApartInfoData> findApartInfo(@RequestParam String apartName, @RequestParam String streetAddress) {
//        return ResponseEntity.ok().body(apartService.findByApartDetailData(apartName,streetAddress));
        System.out.println("apartName = " + apartName);
        System.out.println("streetAddress = " + streetAddress);
        List<TradingHistory> tradingHistories1 = List.of(
                TradingHistory.builder().date(LocalDate.of(2022,1,1)).price(5.6).build(),
                TradingHistory.builder().date(LocalDate.of(2022,1,2)).price(6.7).build(),
                TradingHistory.builder().date(LocalDate.of(2022,1,3)).price(7.8).build(),
                TradingHistory.builder().date(LocalDate.of(2022,1,4)).price(7.2).build(),
                TradingHistory.builder().date(LocalDate.of(2022,1,5)).price(5.4).build(),
                TradingHistory.builder().date(LocalDate.of(2022,1,6)).price(8.9).build(),
                TradingHistory.builder().date(LocalDate.of(2022,1,7)).price(10.2).build()
        );
        List<TradingHistory> tradingHistories2 = List.of(
                TradingHistory.builder().date(LocalDate.of(2022,1,1)).price(4.3).build(),
                TradingHistory.builder().date(LocalDate.of(2022,1,2)).price(5.7).build(),
                TradingHistory.builder().date(LocalDate.of(2022,1,3)).price(9.8).build(),
                TradingHistory.builder().date(LocalDate.of(2022,1,4)).price(6.2).build(),
                TradingHistory.builder().date(LocalDate.of(2022,1,5)).price(5.4).build(),
                TradingHistory.builder().date(LocalDate.of(2022,1,6)).price(4.9).build(),
                TradingHistory.builder().date(LocalDate.of(2022,1,7)).price(8.2).build()
        );
        LeasableArea leasableArea1 = LeasableArea.builder()
                .name("거래가격")
                .area(59.95)
                .priceHalfYear(7.5)
                .priceOneYear(8.9)
                .priceTwoYear(9.2)
                .monthlyPrice(550000.0)
                .monthlyDeposit(23000000.0)
                .tradingHistories(tradingHistories1).build();
        LeasableArea leasableArea2 = LeasableArea.builder()
                .name("거래가격")
                .area(47.57)
                .priceHalfYear(4.3)
                .priceOneYear(4.9)
                .priceTwoYear(7.5)
                .monthlyDeposit(30000000.0)
                .monthlyPrice(350000.0)
                .tradingHistories(tradingHistories2).build();
        ApartInfoData apartInfoData = ApartInfoData.builder()
                .apartName("개포2차현대아파트")
                .fullAddress("서울특별시 강남구 개포동 언주로 103")
                .netLeasableAreas(List.of(59.95,47.57))
                .tradingHistories(List.of(leasableArea1,leasableArea2))
                .build();
        return ResponseEntity.ok().body(apartInfoData);
    }

}
