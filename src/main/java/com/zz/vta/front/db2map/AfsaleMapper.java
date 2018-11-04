package com.zz.vta.front.db2map;

import com.zz.vta.front.entity.AfsaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 售后DB映射
 */
public interface AfsaleMapper extends JpaRepository<AfsaleEntity,Integer> {
}
