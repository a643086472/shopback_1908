package com.aishang.shopback_1908.dao;

import com.aishang.shopback_1908.po.OrderExt;
import com.aishang.shopback_1908.po.OrderPage;
import com.aishang.shopback_1908.po.Orders;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.MyMapper;

import java.util.List;

@Mapper
public interface OrdersMapper extends MyMapper<Orders> {


    /**
     * @author 周城
     * @date 2020/1/9 9:44
     * @param 获取全部订单
     */

    List<OrderExt> getAllOrders(OrderPage orderPage);


    List<OrderExt> getAllOrders2(List<OrderExt> orders);
    /**
     * @author 周城
     * @date 2020/1/13 9:18
     * @param 获取未付款订单
     */
    List<OrderExt> getNotPayOrders(OrderPage orderPage);

    /**
     * @author 周城
     * @date 2020/1/13 18:11
     * @param 获取未发货订单
     */
    List<OrderExt> unshippedOrders(OrderPage orderPage);

    /**
     * @author 周城
     * @date 2020/1/13 18:11
     * @param 获取已发货订单
     */
    List<OrderExt> getShippedOrders(OrderPage orderPage);

    /**
     * @author 周城
     * @date 2020/1/13 18:11
     * @param 获取已收货订单
     */
    List<OrderExt> getReGoodsOrders(OrderPage orderPage);

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
    @Update("update orders set state = 2 where oid=#{oid} ")
    void changeOrder(Integer oid);

    /**
     * @author 周城
     * @date 2020/1/15 10:55
     * @param 删除订单
     */

    @Delete("delete from orders where oid=#{oid}")
    void delOrder(Integer oid);

    /**
     * @author 周城
     * @date 2020/1/15 10:55
     * @param 删除订单项
     */
    @Delete("delete from orderitem where oid=#{oid}")
    void delOrderItems(Integer oid);
}