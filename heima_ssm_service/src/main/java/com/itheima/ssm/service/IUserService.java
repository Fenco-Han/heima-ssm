package com.itheima.ssm.service;

import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;


import javax.xml.ws.WebServiceException;
import java.util.List;

/**
 * @Author: hanpengfei
 * @Date: 2020/5/13 21:04
 * heima_ssm
 */
public interface IUserService extends UserDetailsService {
    /**
     * 查询所有用户信息
     * @return
     * @throws Exception
     */
    public List<UserInfo> findAll() throws Exception;

    /**
     * 保存所有用户信息
     * @param userInfo
     * @throws Exception
     */
    public void save(UserInfo userInfo) throws Exception;

    /**
     * 查询用户信息详情
     * @param id
     * @return
     * @throws Exception
     */
    public UserInfo findById(String id) throws Exception;
}
