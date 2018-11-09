package com.zz.vta.front.db2map;

import com.zz.vta.front.entity.HonorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 荣誉Db映射
 */
public interface HonorMapper extends JpaRepository<HonorEntity,Integer> {
}
