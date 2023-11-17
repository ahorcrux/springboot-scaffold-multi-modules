package org.ahorcrux.dao.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Xixi
 * @title: EnumDemoStatus
 * @description: 
 * @date 2022/2/28  17:50
 */
@Getter
@AllArgsConstructor
public enum EnumDemoStatus {

    DEMO_0(0,"demo0"),
    DEMO_1(1,"demo1");


    private Integer code;
    private String message;

    /**
     * 根据code定位枚举
     *
     * @param code
     * @return
     */
    public static EnumDemoStatus getEnumByCode(Integer code) {
        for (EnumDemoStatus statusEnum : EnumDemoStatus.values()) {
            if (code.equals(statusEnum.getCode())) {
                return statusEnum;
            }
        }
        return null;
    }

    public static boolean isValid(Integer code){
        boolean flag = false;
        for(EnumDemoStatus reviewStatusEnum : EnumDemoStatus.values()){
            if(reviewStatusEnum.getCode().equals(code)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
