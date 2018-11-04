package com.zz.vta.front.entity;



import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 数据库产品实体类
 */

@Entity
@Builder
@Data
@Table(name = "product_")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductEntity {

    @Id
    @GeneratedValue
    @Column(name = "pro_id")
    private int id;
    //名称
    @Column(name = "pro_name")
    private String pro_name;
    //类型
    @Column(name = "pro_type_id")
    private int pro_type_id;
    //规格
    @Column(name = "pro_spec")
    private  String pro_spec;
    //材质
    @Column(name = "pro_mate")
    private String pro_mate;
    //型号
    @Column(name = "pro_modle")
    private String pro_modle;
    //颜色
    @Column(name = "pro_color")
    private String pro_color;
    //质量
    @Column(name = "pro_weigth")
    private Double pro_weigth;
    //最低价格
    @Column(name = "pro_price")
    private BigDecimal pro_price;
    //包含软件
    @Column(name = "pro_really")
    private int pro_really;
    //描述
    @Column(name = "pro_desc")
    private String pro_desc;
    //参数
    @Column(name = "pro_para")
    private String pro_para;
    //自主开发
    @Column(name = "pro_selfdev")
    private int pro_selfdev;
    //市场价格
    @Column(name = "pro_maprice")
    private BigDecimal pro_maprice;
    //图片
    @Column(name = "pro_image")
    private String pro_image;
    //产品星级
    @Column(name = "pro_star")
    private int pro_star;
    //产品状态
    @Column(name = "pro_state")
    private int pro_state;


}
