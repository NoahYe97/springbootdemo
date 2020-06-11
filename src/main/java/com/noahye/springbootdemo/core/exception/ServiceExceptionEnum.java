package com.noahye.springbootdemo.core.exception;

/**
 * 全局异常枚举类
 *
 * @author YePengfei
 * @date 2020-05-15
 */
public enum ServiceExceptionEnum {

    /**
     * 服务错误
     */
    SYS_ERROR(500, "服务端发生异常"),
    MISSING_REQUEST_PARAM_ERROR(501, "参数缺失"),
    ;

    /**
     * 错误码
     */
    private final Integer code;

    /**
     * 错误信息
     */
    private final String message;

    ServiceExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
