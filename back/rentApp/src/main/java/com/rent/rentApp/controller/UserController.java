package com.rent.rentApp.controller;

import com.rent.rentApp.model.Admin;
import com.rent.rentApp.model.User;
import com.rent.rentApp.service.impl.UserServiceImpl;
import com.rent.rentApp.util.MsgResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController//表示所有数据都使用json格式返回
//@RequestMapping("/")
public class UserController {
    //自动注入实现类
    @Autowired
    private UserServiceImpl userService;
    //spring 项目运行之后可以根据http://ip:port/example/register调用这个函数
    /**
     * 用户注册模块
     * @param admin
     * @return
     */
    @RequestMapping(value = "/user/registUser", method = RequestMethod.POST)
    public MsgResponse register(@RequestBody Admin admin){
        MsgResponse register = userService.register(admin);
        return register;
    }

    /**
     * 用户登录模块
     * @param admin
     * @return
     */
    @PostMapping("user/loginUser")
    public MsgResponse login(@RequestBody Admin admin){
        MsgResponse login = userService.login(admin);
        return login;
    }


    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/addUserInfo", method = RequestMethod.POST)
    public MsgResponse addUserInfo(@RequestBody User user){
//      调用userService接口
        MsgResponse msgResponse = userService.addUserInfo(user);
        return msgResponse;
    }


    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/getUserInfo", method = RequestMethod.POST)
    public MsgResponse getUserInfo(@RequestBody User user){
        MsgResponse msgResponse = userService.getUserInfo(user);
        return msgResponse;

    }


    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/userInfoUpdate", method = RequestMethod.POST)
    public MsgResponse userInfoUpdate(@RequestBody User user){

        userService.userInfoUpdate(user);
        return null;
    }

}
