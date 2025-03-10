package org.mrgis.demo.pojo;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;//主键ID
    private String username;//姓名
    @JsonIgnore//转换为json时忽略
    private String password;//密码
    private Integer gender;//性别
    private String identity;//身份
    @Email
    private String email;//邮箱
    private String userPic;//用户头像地址
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
