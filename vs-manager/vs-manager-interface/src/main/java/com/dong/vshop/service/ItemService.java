package com.dong.vshop.service;

import com.dong.vshop.common.dto.Order;
import com.dong.vshop.common.dto.Page;
import com.dong.vshop.common.dto.Result;
import com.dong.vshop.pojo.po.TbItem;
import com.dong.vshop.pojo.vo.TbItemCustom;
import com.dong.vshop.pojo.vo.TbItemQuery;

import java.util.List;

public interface ItemService {
    TbItem getItemById(Long itemId);

    //List<TbItem> getItems();

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    Result<TbItemCustom> listItemsByPage(Page page, Order order, TbItemQuery query);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int updateBatch(List<Long> ids, byte status);

    int saveItem(TbItem item, String content, String paramData);
}
