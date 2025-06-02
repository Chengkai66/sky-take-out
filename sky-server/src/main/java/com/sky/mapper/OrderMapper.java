package com.sky.mapper;


import com.github.pagehelper.Page;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {
    void insert(Orders orders);

    /**
     * 根据订单号查询订单
     *
     * @param orderNumber
     */
    @Select("select * from orders where number = #{orderNumber}")
    Orders getByNumber(String orderNumber);

    /**
     * 修改订单信息
     *
     * @param orders
     */
    void update(Orders orders);

    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);

    @Select("select * from orders where id = #{orderId}")
    Orders getById(Long orderId);

    /**
     * 取消订单
     *
     * @param orderId
     */
    @Update("update orders set status = 6 where id = #{orderId}")
    void cancelSetStatus6(Long orderId);

    @Select("select count(*) from orders where status = #{status}")
    Integer getStatistics(Integer status);

    @Update("update orders set status = #{status} where id = #{id}")
    void setStatus(Long id, Integer status);

    @Select("select * from orders where status = #{status} and order_time < #{time}")
    List<Orders> getOrdersByStatusAndTimeLT(Integer status, LocalDateTime time);

    Double sumTurnoverByMap(Map map);

    Integer countByMap(Map map);
}
