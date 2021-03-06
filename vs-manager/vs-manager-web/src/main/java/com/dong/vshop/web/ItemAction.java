package com.dong.vshop.web;

import com.dong.vshop.common.dto.Page;
import com.dong.vshop.common.dto.Result;
import com.dong.vshop.common.dto.Order;
import com.dong.vshop.pojo.po.TbItem;
import com.dong.vshop.pojo.vo.TbItemCustom;
import com.dong.vshop.pojo.vo.TbItemQuery;
import com.dong.vshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Scope("prototype")
public class ItemAction {

    @Autowired
    private ItemService itemService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    public TbItem getById(@PathVariable("itemId") Long itemId) {
        return itemService.getItemById(itemId);
    }

    //@ResponseBody
    //@RequestMapping("items")
    //public List<TbItem> listItems(){
    //    return itemService.getItems();
    //}

    @ResponseBody
    @RequestMapping("/items")
    public Result<TbItemCustom> listItems(Page page, Order order, TbItemQuery query) {
        Result<TbItemCustom> result = null;
        try {
            result = itemService.listItemsByPage(page, order, query);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/items/batch", method = RequestMethod.POST)
    public int updateBatch(@RequestParam("ids[]") List<Long> ids, byte status) {
        int i = 0;
        try {
            i = itemService.updateBatch(ids, status);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    @ResponseBody
    @RequestMapping(value = "/item")
    public int saveItem(TbItem item, String content, String paramData) {
        int i = 0;
        try {
            i = itemService.saveItem(item, content, paramData);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }
}
