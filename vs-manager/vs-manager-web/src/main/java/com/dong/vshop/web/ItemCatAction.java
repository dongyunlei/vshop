package com.dong.vshop.web;

import com.dong.vshop.common.dto.TreeNode;
import com.dong.vshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@Scope("prototype")
public class ItemCatAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemCatService itemCatService;

    @ResponseBody
    @RequestMapping("/itemCats")
    public List<TreeNode> listItemCatsByParentId(@RequestParam("parentId") Long parentId){

        List<TreeNode> treeNodeList = null;
        try {
            treeNodeList = itemCatService.listItemCatsByParentId(parentId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return treeNodeList;
    }
}
