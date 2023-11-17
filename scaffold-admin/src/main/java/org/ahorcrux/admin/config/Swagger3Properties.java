package org.ahorcrux.admin.config;

import lombok.Data;

@Data
public class Swagger3Properties {

        /**
         * 是否开启swagger，生产环境一般关闭，所以这里定义一个变量
         */
        private Boolean enable;

        /**
         * 项目应用名
         */
        private String applicationName;

        /**
         * 项目版本信息
         */
        private String applicationVersion;

        /**
         * 项目描述信息
         */
        private String applicationDescription;

        /**
         * 接口调试地址
         */
        private String tryHost;
}
