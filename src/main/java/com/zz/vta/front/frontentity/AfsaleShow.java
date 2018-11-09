package com.zz.vta.front.frontentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 售后实体类
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AfsaleShow {
    //id
    private int intAfId;

    //发起人
    private String srtAfName;

    //售后状态
    private int intAfState;

    //发起时间
    private Date DateAfDate;

    //地点
    private String strAfPlace;

    //电话
    private String strAfTel;
}
