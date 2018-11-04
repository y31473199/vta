package com.zz.vta.front.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * 管理员实体类
 */

@Entity
@Builder
@Data
@Table(name = "admin_")

public class AdminEntity {

    @Id
    @GeneratedValue
    @Column(name = "a_id")
    private int a_id;
    //用户名
    @Column(name = "a_name")
    private String a_name;
    //密码
    @Column(name = "a_password")
    private String a_password;
    //姓名
    @Column(name = "a_reaname")
    private String a_reaname;
    //管辖范围
    @Column(name = "a_air")
    private String a_air;
    //手机
    @Column(name = "a_tel")
    private String a_tel;
    //状态
    @Column(name = "a_state")
    private int a_state;
}
