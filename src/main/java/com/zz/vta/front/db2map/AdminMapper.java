package com.zz.vta.front.db2map;

import com.zz.vta.front.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 后台管理员Db映射
 */
@Transactional
@Repository
public interface AdminMapper extends JpaRepository<AdminEntity,Integer> {

    @Query("select a from AdminEntity a where (a.a_name = ?1 or a.a_tel = ?1) and a.a_password = ?2")
    AdminEntity checkUser(String user,String passwd);
}
