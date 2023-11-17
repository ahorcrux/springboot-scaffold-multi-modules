package org.ahorcrux.api.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.ahorcrux.common.exception.IErrorCode;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 通用返回对象
 * Created by macro on 2019/4/19.
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
public class ApiResp<T> implements Serializable {

    private static final long serialVersionUID = 2520762783876870320L;

    /**
     * 状态码
     */
    private String code;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 数据封装
     */
    private T data;

    public static <T> ApiResp<T> ok() {
        return ok(null);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ApiResp<T> ok(T data) {
        return ok(null, data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> ApiResp<T> ok(String message, T data) {
        return result(IErrorCode.SUCCESS, message, data);
    }

    /**
     * 失败返回结果
     */
    public static <T> ApiResp<T> fail(){
        return fail(IErrorCode.FAIL);
    }

    public static <T> ApiResp<T> fail(IErrorCode errorCode) {
        return result(errorCode, null, null);
    }

    public static <T> ApiResp<T> fail(IErrorCode errorCode, T data) {
        return result(errorCode, null, data);
    }

    public static <T> ApiResp<T> fail(IErrorCode errorCode, String message) {
        return result(errorCode, message, null);
    }

    public static <T> ApiResp<T> fail(String message){
        return result(IErrorCode.FAIL,message,null);
    }

    private static <T> ApiResp<T> result(IErrorCode errorCode, String message, T data){
        boolean success = false;
        if (IErrorCode.SUCCESS.code().equals(errorCode.code())){
            success = true;
        }
        if(StringUtils.isBlank(message)){
            message = errorCode.message();
        }
        ApiResp apiResp = ApiResp.builder()
                .code(errorCode.code())
                .message(message)
                .data(data)
                .success(success)
                .build();
        return apiResp;
    }
}
