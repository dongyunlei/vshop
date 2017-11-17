package com.dong.vshop.service.impl;

import com.dong.vshop.common.dto.Order;
import com.dong.vshop.common.dto.Page;
import com.dong.vshop.common.dto.Result;
import com.dong.vshop.common.util.IDUtils;
import com.dong.vshop.dao.TbItemCustomMapper;
import com.dong.vshop.dao.TbItemDescMapper;
import com.dong.vshop.dao.TbItemMapper;
import com.dong.vshop.dao.TbItemParamItemMapper;
import com.dong.vshop.pojo.po.TbItem;
import com.dong.vshop.pojo.po.TbItemDesc;
import com.dong.vshop.pojo.po.TbItemExample;
import com.dong.vshop.pojo.po.TbItemParamItem;
import com.dong.vshop.pojo.vo.TbItemCustom;
import com.dong.vshop.pojo.vo.TbItemQuery;
import com.dong.vshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemMapper itemDao;

    @Autowired
    private TbItemCustomMapper tbItemCustomDao;

    @Autowired
    private TbItemDescMapper itemDescDao;

    @Autowired
    private TbItemParamItemMapper itemParamItemDao;

    @Override
    public TbItem getItemById(Long itemId) {
        return itemDao.selectByPrimaryKey(itemId);
    }

    //@Override
    //public List<TbItem> getItems() {
    //    return itemDao.selectByExample(null);
    //}


    @Override
    public Result<TbItemCustom> listItemsByPage(Page page, Order order, TbItemQuery query) {
        Map<String, Object> map = new HashMap<>();
        map.put("page",page);
        map.put("order",order);
        map.put("query",query);
        Result<TbItemCustom> result = null;
        try {
            result = new Result<TbItemCustom>();
            result.setTotal(tbItemCustomDao.countItems(map));
            result.setRows(tbItemCustomDao.listItemsByPage(map));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateBatch(List<Long> ids, byte status) {
        int i = 0;
        try {
            TbItem item = new TbItem();
            item.setStatus(status);
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            i = itemDao.updateByExampleSelective(item, example);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    @Override
    @Transactional
    public int saveItem(TbItem item, String content, String paramData) {
        int i = 0;
        try {
            long itemId = IDUtils.getItemId();
            item.setId(itemId);
            item.setStatus((byte)2);
            item.setCreated(new Date());
            item.setUpdated(new Date());
            i = itemDao.insert(item);

            TbItemDesc itemDesc = new TbItemDesc();
            itemDesc.setItemId(itemId);
            itemDesc.setItemDesc(content);
            itemDesc.setCreated(new Date());
            itemDesc.setUpdated(new Date());
            i += itemDescDao.insert(itemDesc);

            TbItemParamItem itemParamItem = new TbItemParamItem();
            itemParamItem.setItemId(itemId);
            itemParamItem.setParamData(paramData);
            itemParamItem.setCreated(new Date());
            itemParamItem.setUpdated(new Date());
            i += itemParamItemDao.insert(itemParamItem);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
}
