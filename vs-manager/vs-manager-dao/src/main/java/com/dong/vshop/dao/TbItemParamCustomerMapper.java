package com.dong.vshop.dao;

import com.dong.vshop.common.dto.Page;
import com.dong.vshop.pojo.vo.TbItemParamCustomer;

import java.util.List;

public interface TbItemParamCustomerMapper {

    List<TbItemParamCustomer> listItemParamsByPage(Page page);

    int countItemParams();
}