package org.ahorcrux.admin.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Slf4j
@Aspect
@Configuration
public class LogControllerAspect {
    @Pointcut("execution(* org.ahorcrux.admin.*Controller.*(..))")
    public void log(){
        //该方法需要空
    }


    @Around("log()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        String method = request.getMethod();
        String uri = request.getRequestURI();
        Object[] args = pjp.getArgs();
        //序列化时过滤掉request和response
        List<Object> logArgs = streamOf(args)
                .filter(arg -> (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)))
                .collect(Collectors.toList());
        String reqJson = JSON.toJSONString(logArgs);
        long start = System.currentTimeMillis();

        log.info("========WEB=========>>> {} ==> method: {}, req: {}", uri, method, reqJson);
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();

        log.info("========WEB=========<<< time:{}ms ,resp:{}",end-start,JSON.toJSONString(result));
        return result;
    }

    public static <T> Stream<T> streamOf(T[] array) {
        return ArrayUtils.isEmpty(array) ? Stream.empty() : Arrays.asList(array).stream();
    }

}
