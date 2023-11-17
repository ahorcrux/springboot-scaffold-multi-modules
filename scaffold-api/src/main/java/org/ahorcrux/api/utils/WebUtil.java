package org.ahorcrux.api.utils;

import org.ahorcrux.api.common.jwt.JwtKeys;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.net.URLEncoder;

public class WebUtil {

    public static Long cid(HttpServletRequest request){
        String cid = (String)request.getAttribute(JwtKeys.CID);
        /*String cid = request.getHeader(JwtKeys.CID);
        if(StringUtils.isBlank(cid)){
            cid = (String)request.getAttribute(JwtKeys.CID);
        }*/
        return Long.valueOf(cid);
    }

    /**
     * 获取client ip
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");  
        if (ip != null && !"".equals(ip) && !"unKnown".equalsIgnoreCase(ip)) {
             // 多次反向代理后会有多个ip值，第一个ip才是真实ip  
            int index = ip.indexOf(",");  
            if (index != -1) {  
                return ip.substring(0, index);  
            } else {  
                return ip;  
            }  
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 文件名编码：解决下载时文件名乱码
     * @param fileName
     * @param request
     * @return
     * @throws Exception
     */
    public static String toUtf8(String fileName, HttpServletRequest request) throws Exception {
        final String userAgent = request.getHeader("USER-AGENT");
        String finalFileName = null;
        if (StringUtils.contains(userAgent, "MSIE")||StringUtils.contains(userAgent, "Trident")) {// IE浏览器（旧版/新版）
            finalFileName = URLEncoder.encode(fileName, "UTF8");
        } else if (StringUtils.contains(userAgent, "Mozilla")) { // google,火狐浏览器
            finalFileName = URLEncoder.encode(fileName, "UTF8");
        } else {
            finalFileName = URLEncoder.encode(fileName, "UTF8");// 其他浏览器
        }
        return finalFileName;
    }

    /**
     * BigDecimal出参统一格式化精度处理
     * @param value
     * @return
     */
    public static String scale(BigDecimal value){
        if(null == value){
            return null;
        }
        return value.setScale(8, BigDecimal.ROUND_HALF_DOWN).toPlainString();
    }
}
