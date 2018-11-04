package com.zz.vta.back.resentity;

import lombok.Getter;

@Getter
public enum RespCode {
    SUCCESS(10000, "请求成功"),
    FAIL(10002,"网络错误"),
    WARN(10001, "请求失败");

    private int code;
    private String msg;

    RespCode(int code, String msg) {
        this.msg = msg;
        this.code=code;
    }


}
