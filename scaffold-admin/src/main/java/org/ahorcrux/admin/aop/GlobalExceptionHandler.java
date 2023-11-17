package org.ahorcrux.admin.aop;

import lombok.extern.slf4j.Slf4j;
import org.ahorcrux.api.common.ApiResp;
import org.ahorcrux.common.exception.BizException;
import org.ahorcrux.common.exception.IErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	@ExceptionHandler(Exception.class)
    public ApiResp<?> handleException(HttpServletRequest request, Exception e) {
		log.error(e.getMessage(), e);
        return ApiResp.fail(IErrorCode.FAIL);
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResp<?> handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
    	log.warn("MethodArgumentNotValidException:{}",e.getBindingResult().getFieldError().getDefaultMessage());
        return ApiResp.fail(IErrorCode.PARAM_INVALID, e.getBindingResult().getFieldError().getDefaultMessage());
    }
        
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	@ExceptionHandler(BizException.class)
    public ApiResp<?> handleCommonException(HttpServletRequest request, BizException e) {
        log.warn(e.getMessage(),e);
        return ApiResp.fail(e.getResult(),null);
    }

}
