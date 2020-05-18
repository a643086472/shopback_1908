package com.aishang.shopback_1908.controller;

import com.aishang.shopback_1908.po.OrderExt;
import com.aishang.shopback_1908.po.OrderPage;
import com.aishang.shopback_1908.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/getAllOrders")
    public PageInfo<OrderExt> getAllOrders(@RequestBody OrderPage orderPage){

        /**
         * @author 周城
         * @date 2020/1/9 9:44
         * @param 获取全部订单
         */
        PageInfo<OrderExt> allOrders =  orderService.getAllOrders(orderPage);
        return allOrders;
    }

    @RequestMapping("/getNotPayOrders")
    public PageInfo<OrderExt> getNotPayOrders(@RequestBody OrderPage orderPage){
        /**
         * @author 周城
         * @date 2020/1/13 9:17
         * @param 获取未付款订单
         */
        PageInfo<OrderExt> notPayOrders = orderService.getNotPayOrders(orderPage);
        return notPayOrders;
    }

    /**
     * @author 周城
     * @date 2020/1/13 18:11
     * @param 获取未发货订单
     */
    @RequestMapping("/unshippedOrders")
    public PageInfo<OrderExt> unshippedOrders(@RequestBody OrderPage orderPage){
        PageInfo<OrderExt> unshippedOrders = orderService.unshippedOrders(orderPage);
        return unshippedOrders;
    }

    /**
     * @author 周城
     * @date 2020/1/14 10:08
     * @param 获取已发货订单
     */
    @RequestMapping("/getShippedOrders")
    public PageInfo<OrderExt> getShippedOrders(@RequestBody OrderPage orderPage){

        PageInfo<OrderExt> shippedOrders = orderService.getShippedOrders(orderPage);
        return shippedOrders;
    }

    /**
     * @author 周城
     * @date 2020/1/14 11:03
     * @param 获取已收货订单
     */
    @RequestMapping("/getReGoodsOrders")
    public PageInfo<OrderExt> getReGoodsOrders(@RequestBody OrderPage orderPage){
        PageInfo<OrderExt> reGoodsOrders = orderService.getReGoodsOrders(orderPage);
        return reGoodsOrders;
    }

    /**
     * @author 周城
     * @date 2020/1/15 10:23
     * @param 获取订单详情
     */
    @RequestMapping("/getOrderDetail")
    public List<OrderExt> getOrderDetail( Integer oid){
        System.err.println("oid="+oid);
        List<OrderExt> orderDetail = orderService.getOrderDetail(oid);
        return orderDetail;
    }

    /**
     * @author 周城
     * @date 2020/1/15 10:24
     * @param 修改订单状态，实现发货功能
     */
    @RequestMapping("/changeOrder")
    public void changeOrder(Integer oid){
        orderService.changeOrder(oid);
    }

    /**
     * @author 周城
     * @date 2020/1/15 10:55
     * @param 删除订单
     */
    @RequestMapping("/delOrder")
    public void delOrder(Integer oid){
        orderService.delOrderItems(oid);
        orderService.delOrder(oid);
    }
}
