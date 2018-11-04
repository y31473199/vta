package com.zz.vta.front.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * 新闻实体类
 */
@Entity
@Builder
@Data
@Table(name = "news_")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewsEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    //时间
    @Column(name = "news_date")
    private Date news_date;
    //标题
    @Column(name = "news_title")
    private String news_title;
    //内容
    @Column(name = "news_text")
    private String news_text;
    //作者
    @Column(name = "news_anthor")
    private String news_anthor;
    //标签
    @Column(name = "news_tag")
    private String news_tag;
    //状态
    @Column(name = "news_state")
    private int news_state;


}
