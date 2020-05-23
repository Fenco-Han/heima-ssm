package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: hanpengfei
 * @Date: 2020/5/13 11:42
 * heima_ssm
 */
public interface IMemberDao {
    /**
     * 根据id查询旅游信息
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from member where id = #{id}")
    public Member findById(String id) throws Exception;
}
