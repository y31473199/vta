package com.zz.vta.front.db2map;

import com.zz.vta.front.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 新闻DB映射
 */
@Transactional
@Repository
public interface NewsMapper extends JpaRepository<NewsEntity,Integer> {

    @Query("select n from NewsEntity n where n.news_date like ?1")
    List<NewsEntity> getProByDate(String date);
}
