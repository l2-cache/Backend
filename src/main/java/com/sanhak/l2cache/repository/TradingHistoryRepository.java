package com.sanhak.l2cache.repository;

import com.sanhak.l2cache.entity.TradingHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradingHistoryRepository extends JpaRepository<TradingHistoryEntity, Long> {
}
