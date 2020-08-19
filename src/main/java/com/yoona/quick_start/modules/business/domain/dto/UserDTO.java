package com.yoona.quick_start.modules.business.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

/**
 * @Email: m15602498163@163.com
 * @Author: yoonada
 * @Date: 2020/7/15
 * @Time: 4:57 下午
 * @Msg:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String username;

    private String phone;

    private String email;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "avatar_url")
    private String avatarUrl;

}
