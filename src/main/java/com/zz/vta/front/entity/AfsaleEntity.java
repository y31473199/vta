package com.zz.vta.front.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 售后实体类
 */
@Entity
@Builder
@Data
@Table(name = "afsale_")
public class AfsaleEntity {

    @Id
    @GeneratedValue
    @Column(name = "af_id")
    private int af_id;
    //发起人
    @Column(name = "af_name")
    private String af_name;
    //售后状态
    @Column(name = "af_state")
    private int af_state;
    //发起时间
    @Column(name = "af_date")
    private Date af_date;
    //地点
    @Column(name = "af_place")
    private String af_place;
    //电话
    @Column(name = "af_tel")
    private String af_tel;

}
