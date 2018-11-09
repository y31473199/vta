package com.zz.vta.front.frontentity;

import lombok.*;


/**
 * 类型实体类
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeShow {

    //id
     private int tyIntId;
    //类型名称
     private String tyStrName;
    //类型状态
     private int tyIntState;
    //类型级别
     private int tyIntLeave;
}
