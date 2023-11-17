package org.ahorcrux.common.exception;


/**
 * 系统业务级异常
 * 
 * @author zhaoyang
 *
 */
public class BizException extends BaseException {

    private static final long serialVersionUID = 6141146090401109882L;

    /**
     * 构造方法
     * 
     * @param result
     */
    public BizException(IErrorCode result) {
        this(result, result.message());
    }

    /**
     * 构造方法
     * 
     * @param result
     * @param message
     */
    public BizException(IErrorCode result, String message) {
        super(result, message);
    }

    /**
     * 构造方法
     *
     * @param result
     * @param message
     */
    public BizException(String message) {
        super(message);
    }

    /**
     * 构造方法
     * 
     * @param result
     * @param cause
     */
    public BizException(IErrorCode result, Throwable cause) {
        super(result, result.message(), cause);
    }

    /**
     * 构造方法
     * 
     * @param result
     * @param message
     * @param cause
     */
    public BizException(IErrorCode result, String message, Throwable cause) {
        super(result, message, cause);
    }
}