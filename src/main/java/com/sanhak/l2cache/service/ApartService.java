package com.sanhak.l2cache.service;

import com.sanhak.l2cache.dto.ApartAddress;
import com.sanhak.l2cache.entity.ApartEntity;
import com.sanhak.l2cache.repository.ApartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ApartService {

    private final ApartRepository apartRepository;
//    private final ApartAddressRepository apartAddressRepository;

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
}
