package com.dong.vshop.dao;

import com.dong.vshop.common.dto.Order;
import com.dong.vshop.common.dto.Page;
import com.dong.vshop.pojo.vo.TbItemCustom;
import com.dong.vshop.pojo.vo.TbItemQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbItemCustomMapper {
    /**
     * 查询所有商品的数量
     * @return
     */
    int countItems();

    /**
     * 查询指定页面的记录数据
     * @param page
     * @return
     */
    List<TbItemCustom> listItemsByPage(@Param("page") Page page, @Param("order") Order order, @Param("query")TbItemQuery query);
}
