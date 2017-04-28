package test.helloworld.web.dispatcher;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import test.helloworld.web.constants.GlobalConstants;
import test.helloworld.web.message.resp.Image;
import test.helloworld.web.message.resp.ImageMessage;
import test.helloworld.web.message.resp.TextMessage;
import test.helloworld.web.util.HttpPostUploadUtil;
import test.helloworld.web.util.HttpUtils;
import test.helloworld.web.util.MessageUtil;

/**
 * @author Zou Ling
 * @date 2016年9月7日 上午10:02:12
 * @description 消息业务分发处理器
 */
public class MsgDispatcher {
    public static String processMessage(Map<String, Object> map) throws Exception {
    	String openid=(String) map.get("FromUserName"); //用户openid
    	String mpid=(String) map.get("ToUserName");   //公众号原始ID
    	         
    	//文本消息
    	TextMessage txtmsg=new TextMessage();
    	txtmsg.setToUserName(openid);
    	txtmsg.setFromUserName(mpid);
    	txtmsg.setCreateTime(new Date().getTime());
    	txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
    	//图片消息
    	ImageMessage imgmsg = new ImageMessage();
    	imgmsg.setToUserName(openid);
    	imgmsg.setFromUserName(mpid);
    	imgmsg.setCreateTime(new Date().getTime());
    	imgmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_Image);
    	         
    	if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
    		System.out.println("==============这是文字消息！");
    		String content=(String) map.get("Content");
    	    if("1".equals(content)){
    	        txtmsg.setContent("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxff920ddc80fc60c7&redirect_uri=http%3A%2F%2Fchrish.ngrok.cc%2Findex.jsp&scope=snsapi_userinfo&response_type=code&state=1#wechat_redirect");
    	    }else{
    	        txtmsg.setContent("你好，欢迎来到崔用志博客！");
    	    }
    	    return MessageUtil.textMessageToXml(txtmsg);
    	}
         
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
        	System.out.println("==============这是图片消息！");
        	Map<String, String> params = new HashMap<String, String>();
        	params.put("grant_type", "client_credential");
            params.put("appid", GlobalConstants.getString("appid"));
            params.put("secret", GlobalConstants.getString("AppSecret"));
            String jstoken = HttpUtils.sendGet(
                    GlobalConstants.getString("tokenUrl"), params);
            String access_token = JSONObject.fromObject(jstoken).getString(
                    "access_token");
            params.clear();
        	params.put("access_token", access_token);
            params.put("media_id", map.get("MediaId").toString());
            String jsfile = HttpUtils.sendGet(
                    GlobalConstants.getString("mediaUrl"), params);
            System.out.println(jsfile);
        	/*Image img = new Image();
            HttpPostUploadUtil util=new HttpPostUploadUtil();  
            Map<String, String> textMap = new HashMap<String, String>();  
            textMap.put("name", "testname");  
            Map<String, String> fileMap = new HashMap<String, String>();
            String filepath="D:\\3.jpg";
            fileMap.put("userfile", filepath); 
            String mediaidrs = util.formUpload(textMap, fileMap);
            String mediaid=JSONObject.fromObject(mediaidrs).getString("media_id");
            img.setMediaId(mediaid);
            imgmsg.setImage(img);
            return MessageUtil.imageMessageToXml(imgmsg);*/
        }
         
         
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // 链接消息
            System.out.println("==============这是链接消息！");
        }
         
         
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
            System.out.println("==============这是位置消息！");
        }
         
         
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) { // 视频消息
            System.out.println("==============这是视频消息！");
        }
        
        
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_SHORT_VIDEO)) { // 小视频消息
            System.out.println("==============这是小视频消息！");
        }
         
         
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息
            System.out.println("==============这是语音消息！");
        }
 
        return null;
    }
}
