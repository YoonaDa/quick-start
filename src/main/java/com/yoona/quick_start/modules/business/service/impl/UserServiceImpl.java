package com.yoona.quick_start.modules.business.service.impl;

import com.alibaba.fastjson.JSON;
import com.yoona.quick_start.common.enums.CommonEnums;
import com.yoona.quick_start.common.response.SystemResponse;
import com.yoona.quick_start.common.util.RedisUtils;
import com.yoona.quick_start.common.util.UUIDUtil;
import com.yoona.quick_start.modules.business.dao.UserMapper;
import com.yoona.quick_start.modules.business.domain.dto.UserDTO;
import com.yoona.quick_start.modules.business.domain.entity.User;
import com.yoona.quick_start.modules.business.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;


/**
 * @Email: m15602498163@163.com
 * @Author: yoonada
 * @Date: 2020/7/15
 * @Time: 3:28 下午
 * @Msg:
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final RedisUtils redisUtils;

    /**
     * insert
     * @param user
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public SystemResponse insert(User user) {
        user.setUid(UUIDUtil.getUuid());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        try {
//            TODO 根据username去查询是否已经存在
            UserDTO userInfoByUsername = userMapper.getUserInfoByUsername(user.getUsername());
            if (userInfoByUsername != null){
                return SystemResponse.response(CommonEnums.USERNAME_IS_REGISTERED);
            }
            int num = userMapper.insertSelective(user);
            if (num == 1) {
                redisUtils.set(user.getNickName(), JSON.toJSONString(user), 60 * 3);
            } else {
                return SystemResponse.response(CommonEnums.INSERT_ERROR);
            }
        } catch (Exception e) {
            log.warn("insert过程中发生了异常:{}",e.toString());
            // TODO 出现异常则手动回滚 (要在异常抛出之前)
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return SystemResponse.response(CommonEnums.INSERT_ERROR);
        }
        return SystemResponse.response(CommonEnums.INSERT_SUCCESS);
    }

    /**
     * 根据username查询user信息(把密码、创建日期、更新日期忽略了(UserDTO))
     * @param username
     * @return
     */
    @Override
    public SystemResponse getUserInfoByUsername(String username) {
        if (StringUtils.isBlank(username)){
            return SystemResponse.response(CommonEnums.PARAM_IS_NULL);
        }
        UserDTO userDTO = userMapper.getUserInfoByUsername(username);
        if (userDTO==null){
            return SystemResponse.response(CommonEnums.SELECT_ERROR);
        }
        return SystemResponse.response(CommonEnums.SELECT_SUCCESS,userDTO);
    }



    /**
     * 删除
     * @param uid
     * @return
     */
    @Override
    public SystemResponse delete(String uid) {
        if (StringUtils.isBlank(uid)){
            return SystemResponse.response(CommonEnums.PARAM_IS_NULL);
        }
        int i = userMapper.deleteByPrimaryKey(uid);
        if (i==0){
            return SystemResponse.response(CommonEnums.DELETE_ERROR);
        }
        return SystemResponse.response(CommonEnums.DELETE_SUCCESS);
    }

    /**
     * 批量删除
     * @param uid
     * @return
     */

    @Override
    public SystemResponse batchDelete(String[] uid) {
        int i = userMapper.batchDelete(uid);
        if (i!=uid.length){
            return SystemResponse.response(CommonEnums.BATCH_DELETE_ERROR);
        }
        return SystemResponse.response(CommonEnums.BATCH_DELETE_SUCCESS);
    }


    /**
     * 更新
     * @param user
     * @return
     */
    @Override
    public SystemResponse update(User user) {
        user.setUpdateTime(new Date());
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i == 0){
            return SystemResponse.response(CommonEnums.UPDATE_ERROR);
        }
        return SystemResponse.response(CommonEnums.UPDATE_SUCCESS);
    }


}
