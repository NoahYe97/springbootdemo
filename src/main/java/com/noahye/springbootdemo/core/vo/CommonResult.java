package com.noahye.springbootdemo.core.vo;

import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * 通用返回结果
 *
 * @param <T> 结果为泛型
 * @author YePengfei
 * @date 2020-05-15
 */
public class CommonResult<T> implements Serializable {

    public static Integer CODE_SUCCESS = 200;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 将传入的 result 对象，转换成另外一个泛型结果的对象
     * <p>
     * 因为 A 方法返回的 CommonResult 对象，不满足调用其的 B 方法的返回，所以需要进行转换。
     *
     * @param commonResult 传入的 result 对象
     * @param <T>          返回的泛型
     * @return 新的 CommonResult 对象
     */
    public static <T> CommonResult<T> error(CommonResult<?> commonResult) {
        return error(commonResult.getCode(), commonResult.getMessage());
    }

    public static <T> CommonResult<T> error(Integer code, String message) {
        Assert.isTrue(!CODE_SUCCESS.equals(code), "当前code为系统默认正常code");
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.code = code;
        commonResult.message = message;
        return commonResult;
    }

    public static <T> CommonResult<T> success() {
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.code = CODE_SUCCESS;
        commonResult.message = "操作成功";
        return commonResult;
    }

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.code = CODE_SUCCESS;
        commonResult.data = data;
        commonResult.message = "操作成功";
        return commonResult;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
