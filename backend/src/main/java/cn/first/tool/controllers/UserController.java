package cn.first.tool.controllers;

import cn.first.tool.controllers.request.Message;
import cn.first.tool.controllers.request.User;
import cn.first.tool.controllers.response.QueryBalanceResponse;
import cn.first.tool.domain.common.BusinessException;
import cn.first.tool.services.ChatGPTService;
import cn.first.tool.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
@ResponseBody
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public User loginUser(@RequestBody User user)  {
        User user1 = userService.loginUserService(user);
        if(user1==null){
            throw new RuntimeException("用户账号密码不正确");
        }
        return user1;
    }
    @PostMapping("/insert")
    public String insertUser(@RequestBody User user)  {
        userService.inserUserService(user);
        return "用户插入成功";
    }
    @PostMapping("/update")
    public User updatetUser(@RequestBody User user)  {
        return userService.updateUserService(user);
    }

}
