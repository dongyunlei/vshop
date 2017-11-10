package com.dong.vshop.dao;

import com.dong.vshop.common.dto.Page;
import com.dong.vshop.pojo.po.TbItem;

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
    List<TbItem> listItemsByPage(Page page);
}
