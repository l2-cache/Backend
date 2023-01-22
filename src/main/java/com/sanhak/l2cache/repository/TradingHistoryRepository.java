package com.sanhak.l2cache.repository;

import com.sanhak.l2cache.entity.ApartEntity;
import com.sanhak.l2cache.entity.LeasableAreaEntity;
import com.sanhak.l2cache.entity.TradingHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradingHistoryRepository extends JpaRepository<TradingHistoryEntity, Long> {
    List<TradingHistoryEntity> findByLeasableAreaAndAndApart(LeasableAreaEntity leasableArea, ApartEntity apart);
}
