package com.zz.vta.front.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * 类型实体类
 */
@Entity
@Builder
@Data
@Table(name = "type_")
public class TypeEntity {


    @Id
    @GeneratedValue
    @Column(name = "ty_id")
    private int ty_id;
    //类型名称
    @Column(name = "ty_name")
    private String ty_name;
    //类型状态
    @Column(name = "ty_state")
    private int ty_state;
    //类型级别
    @Column(name = "ty_leave")
    private int ty_leave;
}
