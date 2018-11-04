package com.zz.vta.front.db2map;

import com.zz.vta.front.entity.SubscribeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 产品订阅DB映射
 */
public interface SubscribeMapper extends JpaRepository<SubscribeEntity,Integer> {
}
