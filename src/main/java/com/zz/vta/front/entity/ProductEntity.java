package com.zz.vta.front.entity;



import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 数据库产品实体类
 */

@Entity
@Data
@Builder
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
    @Builder.Default
    private String pro_name = "未填写";
    //类型
    @Column(name = "pro_type_id")
    @Builder.Default
    private int pro_type_id = 1;
    //规格
    @Column(name = "pro_spec")
    @Builder.Default
    private  String pro_spec = "未填写";
    //材质
    @Column(name = "pro_mate")
    @Builder.Default
    private String pro_mate = "未填写";
    //型号
    @Column(name = "pro_modle")
    @Builder.Default
    private String pro_modle = "未填写";
    //颜色
    @Column(name = "pro_color")
    @Builder.Default
    private String pro_color = "未填写";
    //质量
    @Column(name = "pro_weigth")
    @Builder.Default
    private Double pro_weigth = 0.0;
    //最低价格
    @Column(name = "pro_price" )
    @Builder.Default
    private BigDecimal pro_price = new BigDecimal(0);
    //包含软件
    @Column(name = "pro_really")
    @Builder.Default
    private int pro_really = 0;
    //描述
    @Column(name = "pro_desc")
    @Builder.Default
    private String pro_desc = "未填写";
    //参数
    @Column(name = "pro_para")
    @Builder.Default
    private String pro_para = "未填写";
    //自主开发
    @Column(name = "pro_selfdev")
    @Builder.Default
    private int pro_selfdev = 0;
    //市场价格
    @Column(name = "pro_maprice")
    @Builder.Default
    private BigDecimal pro_maprice = new BigDecimal(0);
    //图片
    @Column(name = "pro_image")
    @Builder.Default
    private String pro_image = "未填写";
    //产品星级
    @Column(name = "pro_star")
    @Builder.Default
    private int pro_star = 0;
    //产品状态
    @Column(name = "pro_state")
    @Builder.Default
    private int pro_state = 0;


}
