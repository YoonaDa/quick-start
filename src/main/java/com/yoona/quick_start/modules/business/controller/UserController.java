package com.yoona.quick_start.modules.business.controller;

import com.yoona.quick_start.common.response.SystemResponse;
import com.yoona.quick_start.modules.business.domain.entity.User;
import com.yoona.quick_start.modules.business.domain.vo.UserUpdateVO;
import com.yoona.quick_start.modules.business.domain.vo.UserInsertVO;
import com.yoona.quick_start.modules.business.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * @Email: m15602498163@163.com
 * @Author: yoonada
 * @Date: 2020/7/15
 * @Time: 3:36 下午
 * @Msg:
 */
@Api("user")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    @ApiOperation("根据username获取用户信息")
    @GetMapping("/getUserInfo")
    public SystemResponse getUserInfo(String username){
        return userService.getUserInfoByUsername(username);
    }


    /**
     * insert
     * @param userInsertVO
     * @return
     */
    @ApiOperation("insert操作")
    @PostMapping("/insert")
    public SystemResponse insert(@Valid @RequestBody UserInsertVO userInsertVO){
        User user = new User();
        BeanUtils.copyProperties(userInsertVO,user);
        return userService.insert(user);
    }

    /**
     *
     * @param userUpdateVO
     * @return
     */
    @ApiOperation("update操作")
    @PutMapping("/update")
    public SystemResponse update(@Valid @RequestBody UserUpdateVO userUpdateVO){
        User user = new User();
        BeanUtils.copyProperties(userUpdateVO,user);
        return userService.update(user);
    }

    /**
     * 根据uid删除
     * @param uid
     * @return
     */
    @ApiOperation("delete操作")
    @DeleteMapping("/delete")
    public SystemResponse delete(String uid){
        return userService.delete(uid);
    }

    /**
     * 传入uid进行批量删除
     * @param uid
     * @return
     *
     */
    @ApiOperation("批量删除操作")
    @DeleteMapping("/batchDelete")
    public SystemResponse batchDelete(String[] uid){
        return userService.batchDelete(uid);
    }



}
