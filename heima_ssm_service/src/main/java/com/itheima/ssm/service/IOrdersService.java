package com.itheima.ssm.service;
import com.itheima.ssm.domain.Orders;
import java.util.List;

/**
 * @Author: hanpengfei
 * @Date: 2020/5/13 9:45
 * heima_ssm
 */
public interface IOrdersService {
    /**
     * 查询所有订单（分页）
     *
     * @return
     * @throws Exception
     */
    List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
