package com.sanhak.l2cache.service;

import com.sanhak.l2cache.entity.Apart;
import com.sanhak.l2cache.repository.ApartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ApartService {

    private final ApartRepository apartRepository;

    public List<Apart> findAllData() {
        List<Apart> result = apartRepository.findAll();

        if (result.isEmpty()) {
            throw new NoSuchElementException("DB에 데이터가 없습니다.");
        }

        return result;
    }

}
