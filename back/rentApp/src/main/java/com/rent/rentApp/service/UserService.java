package com.rent.rentApp.service;
import com.rent.rentApp.model.Admin;
import com.rent.rentApp.model.User;
import com.rent.rentApp.util.MsgResponse;

public  interface UserService {
//    注册
    MsgResponse register(Admin admin);
//    登录
    MsgResponse login(Admin admin);

//    添加用户信息
    MsgResponse addUserInfo(User user);

    MsgResponse getUserInfo(User user);


//    更新用户信息
    MsgResponse userInfoUpdate(User user);


}

