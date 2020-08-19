package com.yoona.quick_start.modules.business.service;


import com.yoona.quick_start.common.response.SystemResponse;
import com.yoona.quick_start.modules.business.domain.entity.User;

/**
 * @Email: m15602498163@163.com
 * @Author: yoonada
 * @Date: 2020/7/15
 * @Time: 3:27 下午
 * @Msg:
 */
public interface UserService {

    /**
     * insert
     * @param user
     * @return
     */
    SystemResponse insert(User user);

    /**
     * 根据username获取用户信息
     * @param username
     * @return
     */
    SystemResponse getUserInfoByUsername(String username);



    /**
     * 根据uid删除一条记录
     * @param uid
     * @return
     */
    SystemResponse delete(String uid);


    /**
     * 根据uid批量删除
     * @param uid
     * @return
     */
    SystemResponse batchDelete(String[] uid);

    /**
     * 更新
     * @param user
     * @return
     */
    SystemResponse update(User user);
}
