package org.ahorcrux.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.ahorcrux.api.admin.req.ReqDemoAdd;
import org.ahorcrux.api.admin.req.ReqDemoPage;
import org.ahorcrux.api.admin.req.ReqDemoUpdate;
import org.ahorcrux.api.admin.resp.RespInfoDemo;
import org.ahorcrux.api.common.PageResp;
import org.ahorcrux.api.utils.WebUtil;
import org.ahorcrux.api.common.ApiResp;
import org.ahorcrux.service.common.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Api(value = "DemoController", tags = "【Demo】Demo-相关接口")
@RestController
@RequestMapping(value = "/api/v1/admin/demo")
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @ApiOperation(value = "Demo-添加", httpMethod = "POST", notes = "添加Demo")
    @PostMapping(value = "/add")
    public ApiResp add(HttpServletRequest request, @Validated @RequestBody ReqDemoAdd req) {
        Long cid = WebUtil.cid(request);
        demoService.add(req);
        return ApiResp.ok();
    }

    @ApiOperation(value = "Demo-编辑", httpMethod = "POST", notes = "编辑Demo")
    @PutMapping(value = "/update")
    public ApiResp update(HttpServletRequest request,@Validated @RequestBody ReqDemoUpdate req) {
        Long cid = WebUtil.cid(request);
        demoService.update(req);
        return ApiResp.ok();
    }

    @ApiOperation(value = "Demo-删除", httpMethod = "DELETE", notes = "删除Demo")
    @DeleteMapping(value = "/delete/{id}")
    public ApiResp delete(@PathVariable Long id) {
        demoService.del(id);
        return ApiResp.ok();
    }


    @ApiOperation(value = "Demo-详情", httpMethod = "GET", notes = "查询Demo详情")
    @GetMapping(value = "/info/{id}")
    public ApiResp<RespInfoDemo> detail(@PathVariable Long id) {
        return ApiResp.ok(demoService.info(id));
    }

    @ApiOperation(value = "Demo-分页列表", httpMethod = "POST", notes = "查询Demo分页列表")
    @PostMapping(value = "/page")
    public ApiResp<PageResp<RespInfoDemo>> list(@Validated @RequestBody ReqDemoPage req) {
        return ApiResp.ok(demoService.getPage(req));
    }

}
