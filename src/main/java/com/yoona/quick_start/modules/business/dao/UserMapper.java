package com.yoona.quick_start.modules.business.dao;

import com.yoona.quick_start.modules.business.domain.dto.UserDTO;
import com.yoona.quick_start.modules.business.domain.entity.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author yoona
 */
public interface UserMapper extends Mapper<User> {

    /**
     * 根据username查询返回
     * @param username
     * @return
     */
    UserDTO getUserInfoByUsername(String username);

    /**
     * 根据uid批量删除
     * @param uid
     * @return
     */
    int batchDelete(String[] uid);

}