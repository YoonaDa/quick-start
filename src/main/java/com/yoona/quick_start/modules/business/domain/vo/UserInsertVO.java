package com.yoona.quick_start.modules.business.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @Email: m15602498163@163.com
 * @Author: yoonada
 * @Date: 2020/7/16
 * @Time: 4:49 下午
 * @Msg:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInsertVO {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "手机不能为空")
    private String phone;

    @Email(message = "邮箱不正确")
    private String email;

    private String nickName;

    private String remark;

    private String avatarUrl;


}
