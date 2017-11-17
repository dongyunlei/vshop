package com.dong.vshop.web;

import com.dong.vshop.common.dto.Page;
import com.dong.vshop.common.dto.Result;
import com.dong.vshop.pojo.po.TbItemParam;
import com.dong.vshop.pojo.vo.TbItemParamCustomer;
import com.dong.vshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
public class ItemParamAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemParamService itemParamService;

    @ResponseBody
    @RequestMapping("/itemParams")
    public Result<TbItemParamCustomer> listItemParamsByPage(Page page) {
        Result<TbItemParamCustomer> result = null;
        try {
            result = itemParamService.listItemParamsByPage(page);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/itemParam/query/{id}", method = RequestMethod.GET)
    public TbItemParam getItemParamById(@PathVariable("id") Long id) {
        TbItemParam itemParam = null;
        try {
            itemParam = itemParamService.getItemParamById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return itemParam;
    }
}
