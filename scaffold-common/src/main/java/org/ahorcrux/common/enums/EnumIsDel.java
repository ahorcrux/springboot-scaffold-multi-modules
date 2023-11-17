package org.ahorcrux.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Xixi
 * @title: EnumIsDeleted
 * @description: 
 * @date 2021/2/28 17:50
 */
@Getter
@AllArgsConstructor
public enum EnumIsDel {

    NO(0,"未删除"),
    YES(1,"已删除");


    private Integer code;
    private String message;


}
