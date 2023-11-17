package org.ahorcrux.service.common;

import org.ahorcrux.api.admin.req.ReqDemoAdd;
import org.ahorcrux.api.admin.req.ReqDemoPage;
import org.ahorcrux.api.admin.req.ReqDemoUpdate;
import org.ahorcrux.api.admin.resp.RespInfoDemo;
import org.ahorcrux.api.common.PageResp;

public interface IDemoService {
    void add(ReqDemoAdd req);

    void update(ReqDemoUpdate req);

    void del(Long id);

    RespInfoDemo info(Long id);

    PageResp<RespInfoDemo> getPage(ReqDemoPage req);
}
