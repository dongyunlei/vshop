package com.dong.vshop.service;

import com.dong.vshop.pojo.po.TbItem;

import java.util.List;

public interface ItemService {
    TbItem getItemById(Long itemId);

    List<TbItem> getItems();
}
