package com.dong.vshop.service.impl;

import com.dong.vshop.dao.TbItemMapper;
import com.dong.vshop.pojo.po.TbItem;
import com.dong.vshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemDao;

    @Override
    public TbItem getItemById(Long itemId) {
        return itemDao.selectByPrimaryKey(itemId);
    }

    @Override
    public List<TbItem> getItems() {
        return itemDao.selectByExample(null);
    }
}
