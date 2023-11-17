package org.ahorcrux.common.utils;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;
import java.util.UUID;

public class SerialNoUtil {

    public static String bizNo() {
        return "";
    }

    public static String batchNo(Integer size) {
        return DateUtil.format(new Date(), DatePattern.PURE_DATETIME_FORMAT) + size + random(6);
    }

    /**
     * 生成UUID
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 按位数生成随机数
     * @param count
     * @return
     */
    public static String random(int count){
        return RandomStringUtils.randomNumeric(count);
    }

    public static void main(String[] args) {
        for (int i = 0; i<4; i++){
            System.out.println(uuid());
        }
    }
}
