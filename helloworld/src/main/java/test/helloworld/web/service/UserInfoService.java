package test.helloworld.web.service;

import java.util.List;

import test.helloworld.web.bean.UserInfo;

public interface UserInfoService {
    int addUser(UserInfo user);

    List<UserInfo> selectUser(UserInfo user);

    int editUser(UserInfo user);
}
