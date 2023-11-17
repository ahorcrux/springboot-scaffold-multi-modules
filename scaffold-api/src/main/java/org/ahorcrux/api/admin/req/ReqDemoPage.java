package org.ahorcrux.api.admin.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.ahorcrux.api.common.PageReq;

@Data
public class ReqDemoPage extends PageReq {

    @ApiModelProperty(value="demo")
    private String demo;
}
