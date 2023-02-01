package com.sanhak.l2cache.repository;

import com.sanhak.l2cache.entity.LeasableAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeasableAreaRepository extends JpaRepository<LeasableAreaEntity, Long> {
    List<LeasableAreaEntity> findTop15ByOrderByProfitDesc();
}
