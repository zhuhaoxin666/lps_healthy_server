package com.mysoft.lps_healthy_server.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient implements Serializable {

    /**
     *  病人id
    */
    private Long patId;

    /**
     *  病人用户名
     */
    private String nickName;

    /**
     *  病人真实姓名
     */
    private String username;

    /**
     *  病人密码
     */
    private String password;

    @TableField(exist = false)
    private String token;

    /**
     *  病人身份证号
     */
    private String idCard;

    /**
     *  病人电话
     */
    private String phone;

    /**
     *  病人性别
     */
    private String sex;

    /**
     *  病人年龄
    */
    private Integer age;

}
