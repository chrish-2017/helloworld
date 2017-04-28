package test.helloworld.web.mapper;

import java.util.List;

import test.helloworld.web.bean.UserInfo;

public interface UserInfoMapper {
    int addUser(UserInfo user);

    List<UserInfo> selectUser(UserInfo user);

    int editUser(UserInfo user);
}