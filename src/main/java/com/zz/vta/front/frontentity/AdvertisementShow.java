package com.zz.vta.front.frontentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 广告版实体类
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementShow {

    //Id
    private int intAdId;

    //标题
    private String strAdTitle;

    //副标题
    private String strAdRetitle;

    //正文
    private String strAdText;

    //状态
    private int intAdState;

    //图片
    private String strAdImage;

}
