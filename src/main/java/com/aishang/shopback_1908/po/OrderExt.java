package com.aishang.shopback_1908.po;

import java.util.List;

public class OrderExt extends Orders {
    private List<OrderItemExt> orderItems;

    public List<OrderItemExt> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemExt> orderItems) {
        this.orderItems = orderItems;
    }


}
