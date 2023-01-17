package com.sanhak.l2cache.service;

import com.sanhak.l2cache.entity.ApartEntity;
import com.sanhak.l2cache.repository.ApartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

//    public List<ApartAddress> findCityAllData(String city) {
//        List<ApartAddress> cities = apartAddressRepository.findByCity(city);
//
//        if (cities.isEmpty()) {
//            throw new NoSuchElementException("DB에 데이터가 없습니다.");
//        }
//
//        return cities;
//    }
}
