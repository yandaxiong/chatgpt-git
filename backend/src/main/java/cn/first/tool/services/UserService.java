package cn.first.tool.services;

import cn.first.tool.controllers.request.User;
import cn.first.tool.domain.XinQiuConfig;
import cn.first.tool.utils.SqliteUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @author xiong
 * @Description
 * @date 2023-04-07 1:55 下午
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final XinQiuConfig xinQiuConfig;
    public void inserUserService(User user){
        try {
            int insert = SqliteUtils.insert(user, xinQiuConfig.getSqlitePath());
        } catch (SQLException throwables) {
            throw new RuntimeException("插入用户出错，请联系相关人员");
        }
    }
    public User loginUserService(User user){
        try {
            User login = SqliteUtils.login(user, xinQiuConfig.getSqlitePath());
            return login;
        } catch (SQLException throwables) {
            throw new RuntimeException("登录失败，请联系相关人员");
        }
    }
    public User updateUserService(User user){
        try {
            User update = SqliteUtils.update(user, xinQiuConfig.getSqlitePath());
            return update;
        } catch (SQLException throwables) {
            throw new RuntimeException("更新用户信息失败，请联系相关人员");
        }

    }

}
