package com.zz.vta.front.service;

import com.zz.vta.front.db2map.NewsMapper;
import com.zz.vta.front.entity.NewsEntity;
import com.zz.vta.front.entity.TypeEntity;
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
        NewsShow newsShow = new NewsShow();
        DateFormat bf = new SimpleDateFormat("yyyy年MM-dd");
        if (news.getNews_date()==null){
            newsShow.setStrNewsDate("1996-01-01");
        }else {
            newsShow.setStrNewsDate(bf.format(news.getNews_date()));
        }if (news.getNews_anthor()==null){
            newsShow.setStrNewsAnthor("未填写");
        }else {
            newsShow.setStrNewsAnthor(news.getNews_anthor());
        }if (news.getNews_tag()==null){
            newsShow.setStrNewsTag("未设置");
        }else {
            newsShow.setStrNewsTag(news.getNews_tag());
        }if (news.getNews_text()==null){
            newsShow.setStrNewsText("未填写");
        }else {
            newsShow.setStrNewsText(news.getNews_text());
        }if (news.getNews_title()==null){
            newsShow.setStrNewsTitle("未填写");
        }else {
            newsShow.setStrNewsTitle(news.getNews_title());
        }
        newsShow.setIntNewsId((news.getId()));
        newsShow.setIntNewsState(news.getNews_state());
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

    /**
     * 添加新闻
     */
    public void addNews(NewsEntity entity,String img,int id){
        if (id==0){
            entity.setNews_tag(img);
            if (entity.getNews_date()==null){
                entity.setNews_date(new Date());
            }
            newsMapper.saveAndFlush(entity);
        }else {
            entity.setNews_tag(img);
            entity.setId(id);
            if (entity.getNews_date()==null){
                entity.setNews_date(new Date());
            }
            newsMapper.saveAndFlush(entity);
        }
    }

    /**
     * 改变新闻状态
     */
    public boolean deleteNews(int id,int state){
        NewsEntity entity =  newsMapper.findById(id).get();
        entity.setNews_state(state);
        newsMapper.saveAndFlush(entity);
            /*ProductShow show = new ProductShow(proE.getId(),proE.getPro_name(),proE.getPro_type_id(),proT.getTy_name(),proE.getPro_spec(),proE.getPro_mate(),proE.getPro_color(),proE.getPro_modle(),proE.getPro_weigth(),proE.getPro_price(),proE.getPro_maprice(),
                    proE.getPro_really(),proE.getPro_desc(),proE.getPro_para(),String.valueOf(proE.getPro_selfdev()), proE.getPro_image(),proE.getPro_star(),proE.getPro_state());*/
        return true;
    }

}
