package com.dong.vshop.service;

import com.dong.vshop.common.dto.Page;
import com.dong.vshop.common.dto.Result;
import com.dong.vshop.pojo.vo.TbItemParamCustomer;

public interface ItemParamService {

    Result<TbItemParamCustomer> listItemParamsByPage(Page page);
}
