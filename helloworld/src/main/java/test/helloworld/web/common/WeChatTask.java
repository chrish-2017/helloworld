package test.helloworld.web.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import test.helloworld.web.constants.GlobalConstants;
import test.helloworld.web.util.HttpUtils;

/**
 * @author Zou Ling
 * @date 2016年9月7日 上午11:07:26
 * @description 微信两小时定时任务体
 */
public class WeChatTask {
    /**
     * @Description: 任务执行体
     * @param @throws Exception
     */
    public void getToken_getTicket() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "client_credential");
        params.put("appid", GlobalConstants.getString("appid"));
        params.put("secret", GlobalConstants.getString("AppSecret"));
        String jstoken = HttpUtils.sendGet(
                GlobalConstants.getString("tokenUrl"), params);
        String access_token = JSONObject.fromObject(jstoken).getString(
                "access_token"); // 获取到token并赋值保存
        GlobalConstants.interfaceUrlProperties.put("access_token", access_token);
        
        //获取jsticket的执行体
        params.clear();
        params.put("access_token", access_token);
        params.put("type", "jsapi");
        String jsticket = HttpUtils.sendGet(
                GlobalConstants.getString("ticketUrl"), params);
        String jsapi_ticket = JSONObject.fromObject(jsticket).getString(
                "ticket"); 
        GlobalConstants.interfaceUrlProperties
        .put("jsapi_ticket", jsapi_ticket); // 获取到js-SDK的ticket并赋值保存
        System.out.println("jsapi_ticket================================================" + jsapi_ticket);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"token为=============================="+access_token);
    }
 
}
