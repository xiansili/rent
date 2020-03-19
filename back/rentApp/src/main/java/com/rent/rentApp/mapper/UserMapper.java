package com.rent.rentApp.mapper;
import com.rent.rentApp.model.Admin;
import com.rent.rentApp.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    int register(Admin admin);
    Admin login(Admin admin);
    int userInfoUpdate(User user);
    Admin findUserByStuNumber(Integer stuNumber);
    int addUserInfo(User user);
    User findUserByAdminId(Integer adminId);
}
