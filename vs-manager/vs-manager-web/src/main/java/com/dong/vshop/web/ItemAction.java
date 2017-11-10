package com.dong.vshop.web;

import com.dong.vshop.common.dto.Page;
import com.dong.vshop.common.dto.Result;
import com.dong.vshop.pojo.po.TbItem;
import com.dong.vshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Scope("prototype")
public class ItemAction {

    @Autowired
    private ItemService itemService;



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
    public Result<TbItem> listItems(Page page){
        return itemService.listItemsByPage(page);
    }
}
