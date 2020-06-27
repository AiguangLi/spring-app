package com.lios.study.app.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liaiguang
 * @date 2020/6/12
 */
@Data
public class RestResult implements Serializable {
    private Integer code;
    private String message;
    private Object data;

    public RestResult(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public RestResult(ResultCode resultCode, Object data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    public static RestResult success() {
        return new RestResult(ResultCode.Success);
    }

    public static  RestResult success(Object data) {
        return new RestResult(ResultCode.Success, data);
    }

    public static RestResult failure(ResultCode resultCode) {
        return new RestResult(resultCode);
    }

    public static RestResult failure(ResultCode resultCode, Object data) {
        return new RestResult(resultCode, data);

    }
}