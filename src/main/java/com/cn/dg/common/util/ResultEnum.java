package com.cn.dg.common.util;

/**
 * @Description: 响应状态枚举
 * @Auther: zcz
 * @create 2020/4/16 11:51
 */
public enum ResultEnum {
    SUCCESS(200, "成功"),
    FAIL(201, "失败"),
    ERROR(500, "未知异常");

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}