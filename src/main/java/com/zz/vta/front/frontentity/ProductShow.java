package com.zz.vta.front.frontentity;

import lombok.*;

import java.math.BigDecimal;

/**
 * 前台商品实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductShow {

    //id
    private int intProId;

    //名字
    @Builder.Default
    private String strProName;

    //类型
    @Builder.Default
    int  strProType;

    @Builder.Default
    String proType;

    //规格
    @Builder.Default
    private String strProSpec;

    //材质
    @Builder.Default
    private String strProMate;

    //颜色
    @Builder.Default
    private String strProColor;

    //型号
    @Builder.Default
    private String strProModle;

    //质量
    @Builder.Default
    private Double douProWeigth;

    //最低价格
    @Builder.Default
    private BigDecimal bigProPrice;

    //市场价格
    @Builder.Default
    private BigDecimal bigProMaprice;

    //理实一体
    @Builder.Default
    private int intProReally;

    //描述
    @Builder.Default
    private String strProDesc;

    //参数
    @Builder.Default
    private String strProPara;

    //自主开发
    @Builder.Default
    private String strProSelfdev;

    //图片路径
    @Builder.Default
    private String strProImage;

    //产品星级
    @Builder.Default
    private int intProStar;

    //产品状态
    @Builder.Default
    private int intProState;


}
