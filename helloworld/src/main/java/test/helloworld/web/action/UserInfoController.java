package test.helloworld.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.helloworld.web.bean.UserInfo;
import test.helloworld.web.service.UserInfoService;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @RequestMapping("/add")
    public int addUser(UserInfo user) {
        return userInfoService.addUser(user);
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<UserInfo> selectUser(UserInfo user) {
        try {
            return userInfoService.selectUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/edit")
    public int editUser(UserInfo user) {
        return userInfoService.editUser(user);
    }
}
