package com.cn.dg.common.util;


import lombok.Data;

/**
 * @Description: 统一响应
 * @Auther: zcz
 * @create 2020/4/16 11:51
 */
@Data
public class Result {

    /**
     * 响应状态
     */
    private Integer code;
    private String message;
    private Object data;

    public Result() {
    }

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public static Result ok(String message) {
        return new Result(ResultEnum.SUCCESS.getCode(), message);
    }

    public static Result ok(Object data) {
        return new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public static Result ok() {
        return new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage());
    }

    public static Result ok(int code, String message) {
        return new Result(code, message);
    }

    public static Result fail() {
        return new Result(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMessage());
    }

    public static Result fail(String message) {
        return new Result(ResultEnum.FAIL.getCode(), message);
    }

    public static Result fail(Integer code, String message) {
        return new Result(code, message);
    }

    public static Result error() {
        return new Result(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMessage());
    }

    public static Result error(String message) {
        return new Result(ResultEnum.ERROR.getCode(), message);
    }

    public static Result error(Integer code, String message) {
        return new Result(code, message);
    }

    public static Result data(Object data) {
        return new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }


}