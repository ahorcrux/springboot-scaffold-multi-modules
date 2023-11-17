package org.ahorcrux.api.admin.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Xixi
 * @title: EthWalletCreateReq
 * @description: TODO
 * @date 2022 /2/2819:57
 */
@Data
public class ReqDemoAdd {

    @NotBlank(message = "key is blank")
    @ApiModelProperty(value = "demo")
    private String demo;
}
