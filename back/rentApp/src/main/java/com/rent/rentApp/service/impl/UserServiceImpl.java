package com.rent.rentApp.service.impl;
import com.rent.rentApp.mapper.UserMapper;
import com.rent.rentApp.model.Admin;
import com.rent.rentApp.model.User;
import com.rent.rentApp.service.UserService;
import com.rent.rentApp.util.MsgResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//    实现类
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 注册
     * @param admin
     * @return
     */
    @Override
    public MsgResponse register(Admin admin) {
        MsgResponse msgResponse = new MsgResponse();
        Admin existUser = userMapper.findUserByStuNumber(admin.getStuNumber());
        System.out.println(existUser);
        if (existUser != null){
            msgResponse.setMessage("用户已经存在，可直接登录");
        }else {
            userMapper.register(admin);
            msgResponse.setMessage("注册成功");
            msgResponse.setStatus(200);
        }
        return msgResponse;
    }

//    登录
    @Override
    public MsgResponse login(Admin admin) {
        MsgResponse msgResponse = new MsgResponse();

        Admin existUser = userMapper.findUserByStuNumber(admin.getStuNumber());
        if (existUser != null){
            Admin result = userMapper.login(admin);
            if (result == null){
                msgResponse.setMessage("密码错误，请重新输入");
                msgResponse.setStatus(500);
            }else {
                msgResponse.setMessage("登录成功");
                msgResponse.setStatus(200);
                msgResponse.setData(result);
            }
        }else {
            msgResponse.setMessage("学号不存在，请重新输入");
            msgResponse.setStatus(500);
        }
        return msgResponse;
    }

//    添加用户信息
    @Override
    public MsgResponse addUserInfo(User user) {
        MsgResponse msgResponse = new MsgResponse();
        User userByStuNumber = userMapper.findUserByAdminId(user.getAdminId());
        if (userByStuNumber==null){
            User userInfo = userMapper.findUserByAdminId(user.getAdminId());
            int result = userMapper.addUserInfo(user);
            if (result == 1){

                msgResponse.setStatus(200);
                msgResponse.setMessage("添加用户信息成功");
                msgResponse.setData(userInfo);
            } else{
                msgResponse.setStatus(500);
                msgResponse.setMessage("添加用户信息失败");
            }
        }else {
            msgResponse.setStatus(500);
            msgResponse.setMessage("请勿重复添加");
            msgResponse.setData(userByStuNumber);
        }
        return msgResponse;
    }

    //    获取用户信息
    @Override
    public MsgResponse getUserInfo(User user) {
        User userInfo = userMapper.findUserByAdminId(user.getAdminId());
        if (userInfo!=null){

            MsgResponse success = MsgResponse.success("获取成功", userInfo);
            return success;
        }else {
            MsgResponse err = MsgResponse.err("获取失败");
            return err;
        }
    }

//    更新用户信息
    @Override
    public MsgResponse userInfoUpdate(User user) {
        int result = userMapper.userInfoUpdate(user);
        return null;
    }




}
