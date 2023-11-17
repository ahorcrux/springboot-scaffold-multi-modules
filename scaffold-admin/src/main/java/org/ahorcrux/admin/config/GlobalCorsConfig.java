package org.ahorcrux.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局跨域配置
 *
 */
@Configuration
public class GlobalCorsConfig implements WebMvcConfigurer {

    /**
     * 开启请求路径跨域配置
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowCredentials(true)
//                .exposedHeaders("token") // 暴露返回头token，可以让前端获取参数
                .maxAge(3600);
    }

}
