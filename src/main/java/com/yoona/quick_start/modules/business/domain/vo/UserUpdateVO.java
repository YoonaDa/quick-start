package com.yoona.quick_start.modules.business.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Email: m15602498163@163.com
 * @Author: yoonada
 * @Date: 2020/7/16
 * @Time: 4:49 下午
 * @Msg: User更新操作的VO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateVO {

    @NotBlank(message = "uid不能为空")
    private String uid;

    private String username;

    private String password;

    private String phone;

    @Email(message = "邮箱不正确")
    private String email;

    private String nickName;

    private String remark;

    private String avatarUrl;

}
