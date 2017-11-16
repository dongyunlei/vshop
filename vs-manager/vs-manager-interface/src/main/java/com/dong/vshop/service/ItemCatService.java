package com.dong.vshop.service;

import com.dong.vshop.common.dto.TreeNode;

import java.util.List;

public interface ItemCatService {

    List<TreeNode> listItemCatsByParentId(Long parentId);
}
