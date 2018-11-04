package com.zz.vta.front.db2map;

import com.zz.vta.front.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeMapper extends JpaRepository<TypeEntity,Integer> {

    /**
     * 根据类型id查询类型
     */
    @Query("select e from TypeEntity e where e.ty_id = ?1")
    TypeEntity getProType(Integer id);

}
