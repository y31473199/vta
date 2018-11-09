package com.zz.vta.front.db2map;

import com.zz.vta.front.entity.AdvertisementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 广告版DB映射
 */
@Transactional
@Repository
public interface AdvertisementMapper  extends JpaRepository<AdvertisementEntity,Integer> {
}
