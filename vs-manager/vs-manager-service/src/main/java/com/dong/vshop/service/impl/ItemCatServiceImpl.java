package com.dong.vshop.service.impl;

import com.dong.vshop.common.dto.TreeNode;
import com.dong.vshop.dao.TbItemCatMapper;
import com.dong.vshop.pojo.po.TbItemCat;
import com.dong.vshop.pojo.po.TbItemCatExample;
import com.dong.vshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemCatMapper itemCatDao;

    @Override
    public List<TreeNode> listItemCatsByParentId(Long parentId) {
        List<TreeNode> treeNodeList = null;
        try {
            TbItemCatExample example = new TbItemCatExample();
            example.createCriteria().andParentIdEqualTo(parentId);
            List<TbItemCat> catList = itemCatDao.selectByExample(example);

            treeNodeList = new ArrayList<TreeNode>();
            for (int i = 0; i < catList.size(); i++) {
                TreeNode treeNode = new TreeNode();
                TbItemCat itemCat = catList.get(i);
                treeNode.setId(itemCat.getId());
                treeNode.setText(itemCat.getName());
                treeNode.setState(itemCat.getIsParent() ? "closed" : "open");
                treeNodeList.add(treeNode);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return treeNodeList;
    }
}
