package org.mrgis.demo.mapper;

import org.apache.ibatis.annotations.*;
import org.mrgis.demo.pojo.User;

@Mapper
public interface UserMapper {
   //根据用户名查询用户
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);

    //添加用户
    @Insert("insert into user(username,password,identity,create_time,update_time)" +
            " values(#{username},#{md5String},#{identity},now(),now())")
    void add(String username, String md5String,String identity);

    //更新用户信息
    @Update("update user set gender=#{gender},identity=#{identity},email=#{email},update_time=now() where id=#{id}")
    void update(User user);

    //更新用户头像
    @Update("update user set user_pic=#{avatarUrl},update_time=now() where id=#{id}")
    void updateAvatar(String avatarUrl, Integer id);

    //更新密码
    @Update("update user set password=#{md5String},update_time=now() where id=#{id}")
    void updatePwd(String md5String, Integer id);

    //删除用户
    @Delete("delete from user where id=#{id}")
    void delete(Integer id);
}
