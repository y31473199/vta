package com.zz.vta.front.db2map;

import com.zz.vta.front.entity.CaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 案例DB映射
 */
public interface CaseMapper extends JpaRepository<CaseEntity,Integer> {
}
