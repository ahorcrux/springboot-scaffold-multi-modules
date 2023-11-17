package org.ahorcrux.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Boolean 型枚举
 */
@Getter
@AllArgsConstructor
public enum EnumBool {

	FALSE(0, "否"),
	TRUE(1, "是"),
	;

	private Integer code;
	private String description;

	public static EnumBool getEnumByCode(Integer code) {
		for (EnumBool statusEnum : EnumBool.values()) {
			if (code.equals(statusEnum.getCode())) {
				return statusEnum;
			}
		}
		return null;
	}

	public static boolean isValid(Integer code){
		boolean flag = false;
		for(EnumBool booleanEnum : EnumBool.values()){
			if(booleanEnum.getCode().equals(code)){
				flag = true;
				break;
			}
		}
		return flag;
	}
}
