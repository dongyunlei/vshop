package com.dong.vshop.service.impl;

import com.dong.vshop.common.dto.Page;
import com.dong.vshop.common.dto.Result;
import com.dong.vshop.dao.TbItemCustomMapper;
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

    @Autowired
    private TbItemCustomMapper tbItemCustomDao;

    @Override
    public TbItem getItemById(Long itemId) {
        return itemDao.selectByPrimaryKey(itemId);
    }

    //@Override
    //public List<TbItem> getItems() {
    //    return itemDao.selectByExample(null);
    //}


    @Override
    public Result<TbItem> listItemsByPage(Page page) {
        Result<TbItem> result = new Result<TbItem>();
        result.setTotal(tbItemCustomDao.countItems());
        result.setRows(tbItemCustomDao.listItemsByPage(page));
        return result;
    }
}
