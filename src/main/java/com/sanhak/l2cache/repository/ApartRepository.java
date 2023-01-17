package com.sanhak.l2cache.repository;

import com.sanhak.l2cache.entity.ApartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartRepository extends JpaRepository<ApartEntity, Long> {
}
