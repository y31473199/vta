package com.zz.vta.front.frontentity;

import lombok.*;
/**
 * 新闻实体类
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsShow {
    //id
    private int intNewsId;

    //时间
    private String StrNewsDate;

    //标题
    private String strNewsTitle;

    //内容
    private String strNewsText;

    //作者
    private String strNewsAnthor;

    //标签
    private String strNewsTag;

    //状态
    private int intNewsState;




}
