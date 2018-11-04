package com.zz.vta.front.frontentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 前台荣誉实体类
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HonorShow {

    //时间
    private String strHonDate;

    //地点
    private String strHonPlace;

    //图像
    private String strHonImage;

    //类型
    private String strHonType;

    //名称
    private String strHonName;

    //荣誉标语
    private String strHonTag;

    //状态
    private int intHonState;
}
