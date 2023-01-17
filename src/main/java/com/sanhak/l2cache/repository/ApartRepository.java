package com.sanhak.l2cache.repository;

import com.sanhak.l2cache.entity.ApartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartRepository extends JpaRepository<ApartEntity, Long> {
    List<ApartEntity> findByCity(String city);
}
