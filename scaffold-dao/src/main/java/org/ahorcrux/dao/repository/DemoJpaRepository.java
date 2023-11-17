package org.ahorcrux.dao.repository;

import org.ahorcrux.dao.entity.EDemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoJpaRepository extends JpaRepository<EDemo,Long>, JpaSpecificationExecutor<EDemo> {
    EDemo getEDemoByIdAndIsDeleted(Long id, Integer isDeleted);
}
