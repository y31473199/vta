package com.zz.vta.front.db2map;

import com.zz.vta.front.entity.AdvertisementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 广告版DB映射
 */
public interface AdvertisementMapper  extends JpaRepository<AdvertisementEntity,Integer> {
}
