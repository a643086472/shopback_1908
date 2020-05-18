package com.aishang.shopback_1908.po;

public class OrderPage extends OrderExt {
    private Integer pageNow=1;
    private Integer pageSize=8;

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
