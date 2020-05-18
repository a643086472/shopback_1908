package com.aishang.shopback_1908.service;

import com.aishang.shopback_1908.po.OrderExt;
import com.aishang.shopback_1908.po.OrderPage;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService {

    /**
     * @author 周城
     * @date 2020/1/9 9:44
     * @param 获取全部订单
     */
    PageInfo<OrderExt> getAllOrders(OrderPage orderPage);

    /**
     * @author 周城
     * @date 2020/1/13 9:18
     * @param 获取未付款订单
     */
    PageInfo<OrderExt> getNotPayOrders(OrderPage orderPage);

    /**
     * @author 周城
     * @date 2020/1/13 18:11
     * @param 获取未发货订单
     */
    PageInfo<OrderExt> unshippedOrders(OrderPage orderPage);

    /**
     * @author 周城
     * @date 2020/1/14 10:08
     * @param 获取已发货订单
     */
    PageInfo<OrderExt> getShippedOrders(OrderPage orderPage);

    /**
     * @author 周城
     * @date 2020/1/14 11:05
     * @param 获取已收货订单
     */
    PageInfo<OrderExt> getReGoodsOrders(OrderPage orderPage);

    /**
     * @author 周城
     * @date 2020/1/14 16:40
     * @param 获取订单详情
     */
    List<OrderExt> getOrderDetail(Integer oid);

    /**
     * @author 周城
     * @date 2020/1/15 10:24
     * @param 修改订单状态，实现发货功能
     */
    void changeOrder(Integer oid);

    /**
     * @author 周城
     * @date 2020/1/15 10:55
     * @param 删除订单
     */
    void delOrder(Integer oid);
    /**
     * @author 周城
     * @date 2020/1/15 10:55
     * @param 删除订单项
     */
    void delOrderItems(Integer oid);
}
