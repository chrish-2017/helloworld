package test.helloworld.web.action;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import test.helloworld.web.common.JSSDK_Config;
import test.helloworld.web.util.Message;


/**
 * 前端用户微信配置获取
 * @author Zou Ling
 * @date 2016年11月17日 上午9:22:26
 * @description
 */
@Controller
public class WeChatController {
    @RequestMapping(value = "/index")
    public String index(){
        return "/index";
    }
    
    /**
     * 前端获取微信JSSDK的配置参数
     * @param url
     * @return
     */
    @RequestMapping(value = "/jssdk")
    @ResponseBody
    public Message JSSDK_config(@RequestParam(value = "url", required = true) String url) {
        try {
            System.out.println(url);
            Map<String, String> configMap = JSSDK_Config.jsSDK_Sign(url);
            return Message.success(configMap);
        } catch (Exception e) {
            return Message.error();
        }
    }

}
