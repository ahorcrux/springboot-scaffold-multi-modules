package org.ahorcrux.service.common.impl;

import lombok.extern.slf4j.Slf4j;
import org.ahorcrux.api.admin.req.ReqDemoAdd;
import org.ahorcrux.api.admin.req.ReqDemoPage;
import org.ahorcrux.api.admin.req.ReqDemoUpdate;
import org.ahorcrux.api.admin.resp.RespInfoDemo;
import org.ahorcrux.api.common.PageResp;
import org.ahorcrux.common.enums.EnumIsDel;
import org.ahorcrux.common.exception.BizException;
import org.ahorcrux.common.exception.IErrorCode;
import org.ahorcrux.dao.dao.DemoDao;
import org.ahorcrux.dao.entity.EDemo;
import org.ahorcrux.service.common.IDemoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired
    private DemoDao demoDao;

    @Override
    public void add(ReqDemoAdd req){
        EDemo eDemo = EDemo.builder()
                .demo(req.getDemo())
                .build();
        demoDao.save(eDemo);
    }

    @Override
    public void update(ReqDemoUpdate req){
        EDemo eDemo = demoDao.getById(req.getId());
        if(null == eDemo){
            throw new BizException(IErrorCode.FAIL);
        }
        eDemo.setDemo(req.getDemo());
        demoDao.update(eDemo);
    }

    public void del(Long id){
        EDemo eDemo = demoDao.getById(id);
        if(null == eDemo){
            throw new BizException(IErrorCode.FAIL);
        }
        eDemo.setIsDeleted(EnumIsDel.YES.getCode());
        demoDao.update(eDemo);
    }

    public RespInfoDemo info(Long id){
        EDemo eDemo = demoDao.getById(id);
        if(null == eDemo){
            throw new BizException(IErrorCode.FAIL);
        }
        RespInfoDemo resp = new RespInfoDemo();
        BeanUtils.copyProperties(eDemo, resp);
        return resp;
    }

    public PageResp<RespInfoDemo> getPage(ReqDemoPage req){
        Page<EDemo> page = demoDao.pageList(req.getDemo(), 1, req.getPageNum(), req.getPageSize());
        List<RespInfoDemo> respPageList = new ArrayList<>();
        for (EDemo eCoin : page.getContent()) {
            RespInfoDemo respCoinPage = new RespInfoDemo();
            BeanUtils.copyProperties(eCoin, respCoinPage);
            respPageList.add(respCoinPage);
        }
        return PageResp.convert(page, respPageList);
    }
}
