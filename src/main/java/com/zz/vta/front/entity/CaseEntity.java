package com.zz.vta.front.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 案例实体类
 */
@Entity
@Builder
@Data
@Table(name = "case_")
@NoArgsConstructor
@AllArgsConstructor
public class CaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "case_id")
    private int case_id;
    //时间
    @Column(name = "case_date")
    private Date case_date;
    //地点
    @Column(name = "case_place")
    private String case_place;
    //标题
    @Column(name = "case_title")
    private String case_title;
    //描述
    @Column(name = "case_desc")
    private String case_desc;
    //正文
    @Column(name = "case_text")
    private String case_text;
    //图像
    @Column(name = "case_image")
    private String case_image;
    //状态
    @Column(name = "case_state")
    private int case_state;

}
