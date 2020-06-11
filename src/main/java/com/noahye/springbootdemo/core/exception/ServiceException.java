package com.noahye.springbootdemo.core.exception;

/**
 * 业务逻辑错误时抛出的异常
 *
 * @author YePengfei
 * @date 2020-05-15
 */
public final class ServiceException extends RuntimeException {

    /**
     * 错误码
     */
    private final Integer code;

    public ServiceException(ServiceExceptionEnum serviceExceptionEnum) {
        // 使用父类方法，设置message
        super(serviceExceptionEnum.getMessage());
        // 设置错误码
        this.code = serviceExceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
