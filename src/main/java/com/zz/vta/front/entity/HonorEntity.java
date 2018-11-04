package com.zz.vta.front.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 荣誉实体类
 */
@Entity
@Builder
@Data
@Table(name = "honor_")
public class HonorEntity {

    @Id
    @GeneratedValue
    @Column(name = "hon_id")
    private int hon_id;
    //时间
    @Column(name = "hon_date")
    private Date hon_date;
    //地点
    @Column(name = "hon_place")
    private String hon_place;
    //图像
    @Column(name = "hon_image")
    private String hon_image;
    //类型
    @Column(name = "hon_type")
    private String hon_type;
    //名称
    @Column(name = "hon_name")
    private String hon_name;
    //荣誉标语
    @Column(name = "hon_tag")
    private String hon_tag;
    //状态
    @Column(name = "hon_state")
    private int hon_state;

}
