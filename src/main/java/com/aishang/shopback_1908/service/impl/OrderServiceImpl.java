package com.aishang.shopback_1908.service.impl;

import com.aishang.shopback_1908.dao.OrdersMapper;
import com.aishang.shopback_1908.po.OrderExt;
import com.aishang.shopback_1908.po.OrderPage;
import com.aishang.shopback_1908.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public PageInfo<OrderExt> getAllOrders(OrderPage orderPage) {
        /**
         * @author 周城
         * @date 2020/1/9 9:44
         * @param 获取全部订单
         */
        // 设置分页的pageNow和pageSize
        PageHelper.startPage(orderPage.getPageNow(),orderPage.getPageSize());
        // 查询订单
        List<OrderExt> orders = ordersMapper.getAllOrders(orderPage);

        //

        PageInfo<OrderExt> pageInfo = new PageInfo(orders,7);
        return pageInfo;
    }

    /**
     * @author 周城
     * @date 2020/1/13 9:18
     * @param 获取未付款订单
     */
    @Override
    public PageInfo<OrderExt> getNotPayOrders(OrderPage orderPage) {
        // 设置分页的pageNow和pageSize
        PageHelper.startPage(orderPage.getPageNow(),orderPage.getPageSize());
        // 查询订单
        List<OrderExt> notPayOrders = ordersMapper.getNotPayOrders(orderPage);
        //
        PageInfo<OrderExt> pageInfo = new PageInfo(notPayOrders,7);
        return pageInfo;
    }

    /**
     * @author 周城
     * @date 2020/1/13 18:11
     * @param 获取未发货订单
     */
    @Override
    public PageInfo<OrderExt> unshippedOrders(OrderPage orderPage) {

        // 设置分页的pageNow和pageSize
        PageHelper.startPage(orderPage.getPageNow(),orderPage.getPageSize());
        // 查询订单
        List<OrderExt> unshippedOrders = ordersMapper.unshippedOrders(orderPage);
        PageInfo<OrderExt> pageInfo = new PageInfo(unshippedOrders,7);
        return pageInfo;
    }

    /**
     * @author 周城
     * @date 2020/1/14 10:08
     * @param 获取已发货订单
     */
    @Override
    public PageInfo<OrderExt> getShippedOrders(OrderPage orderPage) {
        // 设置分页的pageNow和pageSize
        PageHelper.startPage(orderPage.getPageNow(),orderPage.getPageSize());
        // 查询订单
        List<OrderExt> shippedOrders = ordersMapper.getShippedOrders(orderPage);
        PageInfo<OrderExt> pageInfo = new PageInfo(shippedOrders,7);
        return pageInfo;
    }

    /**
     * @author 周城
     * @date 2020/1/14 11:05
     * @param 获取已收货订单
     */
    @Override
    public PageInfo<OrderExt> getReGoodsOrders(OrderPage orderPage) {
        // 设置分页的pageNow和pageSize
        PageHelper.startPage(orderPage.getPageNow(),orderPage.getPageSize());
        // 查询订单
        List<OrderExt> reGoodsOrders = ordersMapper.getReGoodsOrders(orderPage);
        PageInfo<OrderExt> pageInfo = new PageInfo(reGoodsOrders,7);
        return pageInfo;
    }

    /**
     * @author 周城
     * @date 2020/1/14 16:40
     * @param 获取订单详情
     */
    @Override
    public List<OrderExt> getOrderDetail(Integer oid) {
        return ordersMapper.getOrderDetail(oid);
    }

    /**
     * @author 周城
     * @date 2020/1/15 10:24
     * @param 修改订单状态，实现发货功能
     */
    @Override
    public void changeOrder(Integer oid) {
        ordersMapper.changeOrder(oid);
    }

    /**
     * @author 周城
     * @date 2020/1/15 10:55
     * @param 删除订单
     */
    @Override
    public void delOrder(Integer oid) {
       ordersMapper.delOrder(oid);
    }

    /**
     * @author 周城
     * @date 2020/1/15 10:55
     * @param 删除订单项
     */
    @Override
    public void delOrderItems(Integer oid) {
        ordersMapper.delOrderItems(oid);
    }
}
