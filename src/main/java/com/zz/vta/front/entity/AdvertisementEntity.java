package com.zz.vta.front.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 广告版实体类
 */
@Entity
@Builder
@Data
@Table(name = "advertisement_")
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementEntity {

    @Id
    @GeneratedValue
    @Column(name = "ad_id")
    private int ad_id;
    //标题
    @Column(name = "ad_title")
    private String ad_title;
    //副标题
    @Column(name = "ad_retitle")
    private String ad_retitle;
    //正文
    @Column(name = "ad_text")
    private String ad_text;
    //状态
    @Column(name = "ad_state")
    private int ad_state;
    //图片
    @Column(name = "ad_image")
    private String ad_image;
}
