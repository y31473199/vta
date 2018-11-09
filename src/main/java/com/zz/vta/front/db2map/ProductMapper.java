package com.zz.vta.front.db2map;

import com.zz.vta.front.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 产品db映射
 */
@Transactional
@Repository
public interface ProductMapper extends JpaRepository<ProductEntity,Integer> {

    @Query("select p from ProductEntity p where p.pro_type_id = ?1")
    List<ProductEntity> getProByType(Integer id);

    /**
     * 根据型号查询产品
     */
    @Query(value ="select * from product_  where pro_modle = ?1" ,nativeQuery = true)
    ProductEntity getProByModle(String modle);

}
