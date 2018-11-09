package com.zz.vta.front.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 产品订阅实体类
 */
@Entity
@Builder
@Data
@Table(name = "subscribe_")
public class SubscribeEntity {

    @Id
    @GeneratedValue
    @Column(name = "sub_id")
    private int sub_id;
    //邮箱
    @Column(name = "sub_mail")
    private String sub_mail;
    //时间
    @Column(name = "sub_date")
    private Date sub_date;
    //状态
    @Column(name = "sub_state")
    private int sub_state;
    //ip
    @Column(name = "sub_ip")
    private String sub_ip;
}
