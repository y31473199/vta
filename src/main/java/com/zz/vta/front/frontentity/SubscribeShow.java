package com.zz.vta.front.frontentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 产品订阅实体类
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeShow {

    //邮箱
    private String strSubMail;

    //时间
    private Date dateSubDate;

    //状态
    private int intSubState;

    //ip
    private String strSubIp;

}
