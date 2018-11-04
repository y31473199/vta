package com.zz.vta.front.service;

import com.zz.vta.front.db2map.NewsMapper;
import com.zz.vta.front.entity.NewsEntity;
import com.zz.vta.front.frontentity.NewsShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 新闻转页面实体
 */
@Service
@Transactional
public class NewsService {

    @Autowired
    NewsMapper newsMapper;

    /**
     * 新闻清单
     */
    public List<NewsShow> getNewsAll(){
        List<NewsEntity> list = newsMapper.findAll();
        List<NewsShow> listN = new ArrayList<NewsShow>();
        DateFormat bf = new SimpleDateFormat("yyyy年MM-dd");
        for (int i = 0;i<list.size();i++){
            NewsEntity entity = list.get(i);new NewsShow();
            NewsShow newsShow = new NewsShow(entity.getId(),bf.format(entity.getNews_date()),entity.getNews_title(),entity.getNews_text(),entity.getNews_anthor(),entity.getNews_tag(),entity.getNews_state());
            listN.add(newsShow);
        }
        return listN;
    }

    /**
     * 根据新闻Id查询新闻
     */
    public NewsShow getNew(Integer id){
        NewsEntity news =  newsMapper.findById(id).get();
        System.out.printf("date="+news.getNews_date());
        NewsShow newsShow = new NewsShow();
        DateFormat bf = new SimpleDateFormat("yyyy年MM-dd");
        newsShow.setStrNewsDate(bf.format(news.getNews_date()));
        newsShow.setIntNewsId((news.getId()));
        newsShow.setIntNewsState(news.getNews_state());
        newsShow.setStrNewsAnthor(news.getNews_anthor());
        newsShow.setStrNewsTag(news.getNews_tag());
        newsShow.setStrNewsText(news.getNews_text());
        newsShow.setStrNewsTitle(news.getNews_title());
        return newsShow;
    }

    /**
     * 新闻分页查询
     */
    public Page<NewsEntity> getSeNews(Pageable pageable){
        return newsMapper.findAll(pageable);
    }
    /**
     * 查询新闻日期并分类
     */
    public  List<NewsShow> getNewsData(){
        List<NewsEntity> list = newsMapper.findAll();
        List<NewsShow> listN = new ArrayList<NewsShow>();
        DateFormat bf = new SimpleDateFormat("yyyy年");
        String str = "";
        for (int i = 0;i<list.size();i++){
            NewsShow newsShow = new NewsShow();
            if(!str.equals(bf.format(list.get(i).getNews_date()))){
                newsShow.setStrNewsDate(bf.format(list.get(i).getNews_date()));
            }
            str = bf.format(list.get(i).getNews_date());
            listN.add(newsShow);
        }
        return listN;
    }
}
