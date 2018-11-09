package com.zz.vta.front.frontentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 案例实体类
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaseShow {
    //Id
    private int intCaseId;
    //时间
    private String DateCaseDate;

    //地点
    private String strCasePlace;

    //标题
    private String strCaseTitle;

    //描述
    private String strCaseDesc;

    //正文
    private String strCaseText;

    //图像
    private String strCaseImage;

    //状态
    private int intCaseState;


}
