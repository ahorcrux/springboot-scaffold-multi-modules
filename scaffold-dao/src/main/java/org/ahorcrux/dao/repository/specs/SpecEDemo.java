package org.ahorcrux.dao.repository.specs;

import org.ahorcrux.dao.entity.EDemo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xixi
 * @date 2023/5/28 17:45
 */
public class SpecEDemo {

    public static Specification<EDemo> getSpec(String demo, Integer isDeleted){

        return new Specification<EDemo>() {
            @Override
            public Predicate toPredicate(Root<EDemo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                /*
                 * cb : 构造查询, 相当于where
                 *
                 * root : 即实体表，获取属性
                 */
                if(StringUtils.isNotBlank(demo)){
                    Path<Object> pSymbol = root.get("demo");
                    Predicate p1 = criteriaBuilder.like(pSymbol.as(String.class), "%"+demo+"%");
                    predicates.add(p1);
                }
                if(null != isDeleted){
                    Predicate p2 = criteriaBuilder.equal(root.get("isDeleted"), isDeleted);
                    predicates.add(p2);
                }

                //排序
                query.orderBy(criteriaBuilder.desc(root.get("id")));
                /*
                 * 将多个查询组合到一起(and / or)
                 */
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
