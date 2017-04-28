package test.helloworld.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import test.helloworld.web.bean.UserInfo;
import test.helloworld.web.mapper.UserInfoMapper;
import test.helloworld.web.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public int addUser(UserInfo user) {
        return userInfoMapper.addUser(user);
    }

    @Override
    public List<UserInfo> selectUser(UserInfo user) {
        return userInfoMapper.selectUser(user);
    }

    @Override
    public int editUser(UserInfo user) {
        return userInfoMapper.editUser(user);
    }
}
