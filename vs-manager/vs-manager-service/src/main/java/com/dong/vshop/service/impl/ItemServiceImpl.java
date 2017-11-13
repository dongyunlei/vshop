package com.dong.vshop.service.impl;

import com.dong.vshop.common.dto.Order;
import com.dong.vshop.common.dto.Page;
import com.dong.vshop.common.dto.Result;
import com.dong.vshop.dao.TbItemCustomMapper;
import com.dong.vshop.dao.TbItemMapper;
import com.dong.vshop.pojo.po.TbItem;
import com.dong.vshop.pojo.po.TbItemExample;
import com.dong.vshop.pojo.vo.TbItemCustom;
import com.dong.vshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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
    public Result<TbItemCustom> listItemsByPage(Page page,Order order) {
        Result<TbItemCustom> result = null;
        try {
            result = new Result<TbItemCustom>();
            result.setTotal(tbItemCustomDao.countItems());
            result.setRows(tbItemCustomDao.listItemsByPage(page,order));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateBatch(List<Long> ids,byte status) {
        int i = 0;
        try {
            TbItem item = new TbItem();
            item.setStatus(status);
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            i = itemDao.updateByExampleSelective(item,example);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }
}
