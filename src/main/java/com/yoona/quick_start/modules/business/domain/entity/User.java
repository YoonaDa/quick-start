package com.yoona.quick_start.modules.business.domain.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Data
@Builder
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 用户id
     */
    @Id
    private String uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 头像地址
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;
}