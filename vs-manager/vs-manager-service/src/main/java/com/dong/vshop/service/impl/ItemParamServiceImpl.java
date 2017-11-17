package com.dong.vshop.service.impl;

import com.dong.vshop.common.dto.Page;
import com.dong.vshop.common.dto.Result;
import com.dong.vshop.dao.TbItemParamCustomerMapper;
import com.dong.vshop.pojo.vo.TbItemParamCustomer;
import com.dong.vshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemParamServiceImpl implements ItemParamService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemParamCustomerMapper itemParamCustomerDao;


    @Override
    public Result<TbItemParamCustomer> listItemParamsByPage(Page page) {
        Result<TbItemParamCustomer> result = new Result<>();
        try {
            result.setRows(itemParamCustomerDao.listItemParamsByPage(page));
            result.setTotal(itemParamCustomerDao.countItemParams());
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }
}
