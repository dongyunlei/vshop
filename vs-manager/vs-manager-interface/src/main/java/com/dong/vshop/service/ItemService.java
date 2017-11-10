package com.dong.vshop.service;

import com.dong.vshop.common.dto.Page;
import com.dong.vshop.common.dto.Result;
import com.dong.vshop.pojo.po.TbItem;

import java.util.List;

public interface ItemService {
    TbItem getItemById(Long itemId);

    //List<TbItem> getItems();

    /**
     * 分页查询
     * @param page
     * @return
     */
    Result<TbItem> listItemsByPage(Page page);
}
