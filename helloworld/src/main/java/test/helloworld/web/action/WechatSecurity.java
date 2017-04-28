package test.helloworld.web.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.json.JSONObject;
import test.helloworld.web.common.OauthCode_GetUseInfo;
import test.helloworld.web.constants.GlobalConstants;
import test.helloworld.web.dispatcher.EventDispatcher;
import test.helloworld.web.dispatcher.MsgDispatcher;
import test.helloworld.web.util.HttpUtils;
import test.helloworld.web.util.MessageUtil;
import test.helloworld.web.util.SignUtil;

@Controller
@RequestMapping("/wechat")
public class WechatSecurity {
	private static Logger logger = Logger.getLogger(WechatSecurity.class);
	 
    /**
     * 接收get参数，返回验证参数
     * @param request
     * @param response
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     */
    @RequestMapping(value = "/security", method = RequestMethod.GET)
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "signature", required = true) String signature,
            @RequestParam(value = "timestamp", required = true) String timestamp,
            @RequestParam(value = "nonce", required = true) String nonce,
            @RequestParam(value = "echostr", required = true) String echostr) {
        try {
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
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
                //response.reset();
                PrintWriter out = response.getWriter();
                out.print(echostr);
                out.close();
            } else {
                logger.info("这里存在非法请求！");
            }
        } catch (Exception e) {
            logger.error(e, e);
        }
    }
 
    /**
     * 接收微信服务端消息
     * @param request
     * @param response
     */
    @RequestMapping(value = "/security", method = RequestMethod.POST)
    public void DoPost(HttpServletRequest request,HttpServletResponse response) {
    	try{
    		request.setCharacterEncoding("utf-8"); 
    		response.setCharacterEncoding("utf-8"); 
            Map<String, Object> map=MessageUtil.parseXml(request);
            String msgtype=(String) map.get("MsgType");
            if(MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)){
            	String msgrsp=EventDispatcher.processEvent(map); //进入事件处理
                PrintWriter out = response.getWriter();
                out.print(msgrsp);
                out.close();
            }else{
                String msgrsp=MsgDispatcher.processMessage(map); //进入消息处理
                PrintWriter out = response.getWriter();
                out.print(msgrsp);
                out.close();
            }
        }catch(Exception e){
            logger.error(e,e);
        }
    }
    
    /**
     * 微信授权登录
     * @param request
     * @param response
     * @param code
     * @param state
     */
    @RequestMapping("/weixinOauth")
    public void weiXinOauth(HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "code", required = true) String code,
            @RequestParam(value = "state", required = true) String state) {
        System.out.println("Code============="+code+"==========state======="+state);
        try {
            // 用code取得微信用户的基本信息
            OauthCode_GetUseInfo weixin = new OauthCode_GetUseInfo(code);
            Map<String, String> wmap = weixin.getUserInfo();
            System.out.println("用户昵称================================="
                    + wmap.get("nickname"));
     
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
    }
}
