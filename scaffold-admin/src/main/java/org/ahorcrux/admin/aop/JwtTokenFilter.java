package org.ahorcrux.admin.aop;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.exceptions.TokenExpiredException;
import lombok.extern.slf4j.Slf4j;
import org.ahorcrux.api.common.ApiResp;
import org.ahorcrux.api.common.jwt.JwtKeys;
import org.ahorcrux.api.common.jwt.JwtPayload;
import org.ahorcrux.api.common.jwt.JwtTokenUtil;
import org.ahorcrux.common.enums.EnumChar;
import org.ahorcrux.common.exception.BizException;
import org.ahorcrux.common.exception.IErrorCode;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@WebFilter(filterName = "tokenFilter",urlPatterns =
        {"/api/v1/admin/*"})
public class JwtTokenFilter implements Filter {

    public static final String AUTH = "Authorization";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 设置输出编码格式，如有需要更改text/json返回类型请自行在相应方法中进行修改
        response.setHeader("Content-type", "text/json;charset=UTF-8");
        response.setCharacterEncoding(EnumChar.UTF_8.getCode());

        String token = request.getHeader(AUTH);
        if(StringUtils.isBlank(token)){
            response.getWriter().print(JSON.toJSONString(ApiResp.fail(IErrorCode.TOKEN_INVALID)));
            return;
        }
        try{
            JwtPayload jwtPayload = JwtTokenUtil.verify(token, JwtTokenUtil.JWT_SECRET);
            request.setAttribute(JwtKeys.CID, jwtPayload.getCid());
            request.setAttribute(JwtKeys.CNAME, jwtPayload.getCname());
            filterChain.doFilter(servletRequest, servletResponse);
        }catch (TokenExpiredException e){
            log.info("JWT Token Filter Failed, Error: {}", e.getMessage());
            e.printStackTrace();
            out(response, IErrorCode.TOKEN_EXPIRED);
        }catch (BizException e){
            log.info("JWT Token Filter Failed,  Error: {}", e.getMessage());
            e.printStackTrace();
            out(response, e.getResult());
        }catch (Exception e){
            log.info("JWT Token Filter Failed, Error: {}", e.getMessage());
            e.printStackTrace();
            out(response, IErrorCode.UNAUTHORIZED);
        }
    }

    public void out(HttpServletResponse response, IErrorCode errorCode) throws IOException {
        response.getWriter().print(JSON.toJSONString(ApiResp.fail(errorCode)));
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}
