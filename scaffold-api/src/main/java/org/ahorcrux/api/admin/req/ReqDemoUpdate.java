package org.ahorcrux.api.admin.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Xixi
 * @title: EthWalletCreateReq
 * @description: TODO
 * @date 2022 /2/2819:57
 */
@Data
public class ReqDemoUpdate extends ReqDemoAdd{

    @NotNull(message = "id not be null")
    @ApiModelProperty(value = "id")
    private Long id;
}
