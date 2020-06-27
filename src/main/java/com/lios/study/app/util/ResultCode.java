package com.lios.study.app.util;

import lombok.Getter;

/**
 * Rest返回结果枚举
 * @author LiOS
 * @date 2020-06-12
 */
public enum ResultCode {
    /**
     * Success=成功
     * InvalidParameter=请求参数无效
     * InternalServerError=服务器内部错误
     * UnAuthorized=需登录
     * PermissionDenied=禁止访问资源
     * NotFound=资源未找到
     */
    Success(0,"成功"),
    InvalidParameter(422,"参数无效"),
    InternalServerError(500, "服务器内部错误"),
    UnAuthorized(401, "请先登录"),
    PermissionDenied(403, "无访问权限"),
    NotFound(404, "资源未找到");

    @Getter
    private final Integer code;
    @Getter
    private final String message;

    private ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
