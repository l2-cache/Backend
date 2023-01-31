package com.sanhak.l2cache.service;

import com.sanhak.l2cache.dto.ApartAddress;
import com.sanhak.l2cache.dto.ApartInfoData;
import com.sanhak.l2cache.dto.LeasableArea;
import com.sanhak.l2cache.dto.TradingHistory;
import com.sanhak.l2cache.entity.ApartEntity;
import com.sanhak.l2cache.entity.LeasableAreaEntity;
import com.sanhak.l2cache.entity.TradingHistoryEntity;
import com.sanhak.l2cache.repository.ApartRepository;
import com.sanhak.l2cache.repository.TradingHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ApartService {

    private final ApartRepository apartRepository;
    private final TradingHistoryRepository tradingHistoryRepository;

    public List<ApartEntity> findAllData() {
        List<ApartEntity> result = apartRepository.findAll();

        if (result.isEmpty()) {
            throw new NoSuchElementException("DB에 데이터가 없습니다.");
        }

        return result;
    }

    public List<ApartAddress> findCityAllData(String cityName) {
        List<ApartEntity> cities = apartRepository.findByCity(cityName);
        List<ApartAddress> result = new ArrayList<>();

        for (ApartEntity city : cities) {
            ApartAddress apartAddress = ApartAddress.builder()
                    .id(city.getId())
                    .streetAddress(city.getStreetAddress())
                    .apartName(city.getApartName())
                    .dong(city.getDong())
                    .latitude(city.getLatitude())
                    .longitude(city.getLongitude())
                    .build();
            result.add(apartAddress);
        }

        if (cities.isEmpty()) {
            throw new NoSuchElementException("DB에 데이터가 없습니다.");
        }

        return result;
    }

    public ApartInfoData findByApartDetailData(String apartName, String streetAddress) {
        ApartEntity findData = apartRepository.findByApartNameAndStreetAddress(apartName, streetAddress)
                .orElseThrow(() -> new NoSuchElementException("DB에 데이터가 없습니다."));


        return ApartInfoData.builder()
                .apartName(apartName)
                .fullAddress("서울특별시 " + findData.getCity() + " " + findData.getDong() + " " + findData.getStreetAddress())
                .netLeasableAreas(getNetLeasableAreas(findData.getLeasableAreas()))
                .tradingHistories(getLeasableAreaDto(findData,findData.getLeasableAreas()))
                .build();
    }

    public List<Double> getNetLeasableAreas(List<LeasableAreaEntity> leasableAreas) {
        List<Double> result = new ArrayList<>();

        for (LeasableAreaEntity leasableArea : leasableAreas) {
            result.add(leasableArea.getLeasableArea());
        }
        return result;
    }

    public List<LeasableArea> getLeasableAreaDto(ApartEntity apart, List<LeasableAreaEntity> leasableAreas) {
        List<LeasableArea> result = new ArrayList<>();

        for (LeasableAreaEntity leasableArea : leasableAreas) {
            result.add(LeasableArea.builder()
                    .name("거래가격")
                    .area(leasableArea.getLeasableArea())
                    .predictMonthlyPrice(leasableArea.getAverageMonthlyRentPrice())
                            .priceHalfYear(leasableArea.getPriceHalfYear())
                            .priceOneYear(leasableArea.getPriceOneYear())
                            .priceTwoYear(leasableArea.getPriceTwoYear())
                            .monthlyDeposit(leasableArea.getAverageMonthlyDeposit())
                            .monthlyPrice(leasableArea.getAverageMonthlyRentPrice())
                            .predictMonthlyDeposit(leasableArea.getEstimateMonthlyDeposit())
                            .predictMonthlyPrice(leasableArea.getEstimateMonthlyRentPrice())
                    .tradingHistories(getTradingHistory(apart, leasableArea))
                    .build());
        }
        return result;
    }

    public List<TradingHistory> getTradingHistory(ApartEntity apart, LeasableAreaEntity leasableArea) {
        List<TradingHistory> result = new ArrayList<>();

        List<TradingHistoryEntity> findData = tradingHistoryRepository.findByLeasableAreaAndAndApart(leasableArea,apart);

        for (TradingHistoryEntity data : findData) {
            result.add(TradingHistory.builder()
                    .date(data.getContractDate())
                    .price(Math.round(data.getContractPrice() / 10000.0 * 100) / 100.0)
                    .build()
            );
        }
        return result;
    }
}
