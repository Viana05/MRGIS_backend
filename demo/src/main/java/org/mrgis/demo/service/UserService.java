package org.mrgis.demo.service;

import org.mrgis.demo.pojo.User;

public interface UserService {
    // 根据用户名查询用户
    User findByUserName(String username);

    //注册
    void register(String username, String password, String identity);

    //更新
    void update(User user);

    //更新头像
    void updateAvatar(String avatarUrl);

    //更新密码
    void updatePwd(String newPwd);

    //删除用户
    void delete(Integer id);
}
