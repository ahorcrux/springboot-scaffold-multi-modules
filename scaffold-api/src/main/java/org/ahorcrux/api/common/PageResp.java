package org.ahorcrux.api.common;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据封装类
 * Created by macro on 2019/4/19.
 */
@Data
public class PageResp<T> implements Serializable {
    /**
     * 当前页码
     */
    private Integer pageNum;
    /**
     * 每页数量
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 总条数
     */
    private Long total;
    /**
     * 分页数据
     */
    private List<T> list;

    /**
     * 将SpringData分页后的list转为分页信息
     */
    public static <O,T> PageResp<T> rest(PageResp<O> pageInfo, List<T> list) {
        PageResp<T> result = new PageResp<T>();
        result.setTotalPage(pageInfo.getTotalPage());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(list);
        return result;
    }

    /**
     * 转换Page分页
     */
    public static <O,T> PageResp<T> convert(Page<O> pageInfo, List<T> list) {
        PageResp<T> result = new PageResp<T>();
        result.setTotalPage(pageInfo.getTotalPages());
        result.setPageNum(pageInfo.getNumber() + 1);
        result.setPageSize(pageInfo.getSize());
        result.setTotal(pageInfo.getTotalElements());
        result.setList(list);
        return result;
    }
}
