package org.ahorcrux.dao.dao;

import lombok.extern.slf4j.Slf4j;
import org.ahorcrux.common.enums.EnumIsDel;
import org.ahorcrux.dao.entity.EDemo;
import org.ahorcrux.dao.repository.DemoJpaRepository;
import org.ahorcrux.dao.repository.specs.SpecEDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Slf4j
@Repository
public class DemoDao {

    @Autowired
    private DemoJpaRepository demoJpaRepository;

    public void save(EDemo demo){
        Date current = new Date();
        demo.setIsDeleted(EnumIsDel.NO.getCode());
        demoJpaRepository.save(demo);
    }

    public void update(EDemo demo){
        demo.setGmtModified(new Date());
        demoJpaRepository.save(demo);
    }

    public EDemo getById(Long id){
        return demoJpaRepository.getEDemoByIdAndIsDeleted(id, EnumIsDel.NO.getCode());
    }

    public Page<EDemo> pageList(String symbol, Integer flag, Integer pageNum, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNum-1, pageSize, Sort.by(Sort.Direction.DESC,"id"));
        return demoJpaRepository.findAll(SpecEDemo.getSpec(symbol, flag), pageable);
    }
}
