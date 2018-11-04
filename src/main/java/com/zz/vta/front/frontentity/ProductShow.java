package com.zz.vta.front.frontentity;

import lombok.*;

import java.math.BigDecimal;

/**
 * 前台商品实体类
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class ProductShow {

    //id
    @NonNull private int intProId;

    //名字
    @NonNull private String strProName;

    //类型
    @NonNull int  strProType;

    String proType;

    //规格
    @NonNull private String strProSpec;

    //材质
    @NonNull private String strProMate;

    //颜色
    @NonNull private String strProColor;

    //型号
    @NonNull private String strProModle;

    //质量
    @NonNull private Double douProWeigth;

    //最低价格
    private BigDecimal bigProPrice;

    //市场价格
    @NonNull private BigDecimal bigProMaprice;

    //理实一体
    private int intProReally;

    //描述
    @NonNull private String strProDesc;

    //参数
    @NonNull private String strProPara;

    //自主开发
    private String strProSelfdev;

    //图片路径
    @NonNull private String strProImage;

    //产品星级
    @NonNull private int intProStar;

    //产品状态
    @NonNull private int intProState;


}
