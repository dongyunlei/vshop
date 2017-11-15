package com.dong.vshop.dao;

import com.dong.vshop.pojo.vo.TbItemCustom;
import java.util.List;
import java.util.Map;

public interface TbItemCustomMapper {
    /**
     * 查询所有商品的数量
     * @return
     */
    int countItems(Map<String ,Object> map);

    /**
     * 查询指定页面的记录数据
     * @return
     */
    List<TbItemCustom> listItemsByPage(Map<String ,Object> map);
}
