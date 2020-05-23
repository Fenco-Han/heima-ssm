package com.itheima.ssm.dao;


import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: hanpengfei
 * @Date: 2020/5/13 11:43
 * heima_ssm
 */
public interface ITravellerDao {

    /**
     * 根据订单id查询旅行信息
     * @param orderId
     * @return
     * @throws Exception
     */
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId =#{ordersId})")
    public List<Traveller> findByOrderId(String orderId) throws Exception;
}
