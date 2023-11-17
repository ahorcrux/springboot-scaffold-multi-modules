package org.ahorcrux.api.common;

import lombok.Data;
import org.ahorcrux.common.utils.SerialNoUtil;

import java.io.Serializable;

@Data
public class BaseReq implements Serializable {

    private static final long serialVersionUID = 9216354136713685159L;

    /**
     * 请求流水号
     */
    private String reqNo = SerialNoUtil.uuid();

}