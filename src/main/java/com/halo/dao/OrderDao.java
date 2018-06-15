package com.halo.dao;

import com.halo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author MelloChan
 * @date 2018/6/6
 */
@Mapper
public interface OrderDao {
    /**
     * 插入订单信息
     */
    void insertOrderInfo(Order order);

    /**
     * 根据用户id获取用户的所有订单部分信息
     */
    List<Order> getByUId(@Param("userId") Integer userId);

    /**
     * 根据订单id获取订单状态
     */
    Short getStatusByOrderId(@Param("orderId")String orderId);
}
