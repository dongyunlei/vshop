package com.dong.vshop.common.dto;

/**
 * 封装分页请求的参数
 */
public class Page {

    private int page;
    private int rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * 获取分页偏移量
     */
    public int getOffset() {
        return (page-1)*rows;
    }
}
