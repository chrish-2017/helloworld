package test.helloworld.web.dispatcher;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import test.helloworld.web.common.GetUseInfo;
import test.helloworld.web.message.resp.Article;
import test.helloworld.web.message.resp.NewsMessage;
import test.helloworld.web.message.resp.TextMessage;
import test.helloworld.web.util.MessageUtil;

/**
 * @author Zou Ling
 * @date 2016年9月7日 上午10:05:47
 * @description 事件消息业务分发器
 */
public class EventDispatcher {
    @SuppressWarnings("unchecked")
    public static String processEvent(Map<String, Object> map) {
    	String openid = (String) map.get("FromUserName"); // 用户openid
    	String mpid = (String) map.get("ToUserName"); // 公众号原始ID
    	//图文消息
        NewsMessage newmsg=new NewsMessage();
        newmsg.setToUserName(openid);
        newmsg.setFromUserName(mpid);
        newmsg.setCreateTime(new Date().getTime());
        newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
        
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { //关注事件
        	System.out.println("==============这是关注事件！");
        	try {
	            HashMap<String, String> userinfo=GetUseInfo.Openid_userinfo(openid);
	            Article article=new Article();
	            article.setDescription("欢迎来到崔用志的个人博客：菜鸟程序员成长之路！"); //图文消息的描述
	            article.setPicUrl(userinfo.get("headimgurl")); //图文消息图片地址
	            article.setTitle("尊敬的："+userinfo.get("nickname")+",你好！");  //图文消息标题
	            article.setUrl("http://www.cuiyongzhi.com");  //图文url链接
	            List<Article> list=new ArrayList<Article>();
	            list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里list中加入多个Article即可！
	            newmsg.setArticleCount(list.size());
	            newmsg.setArticles(list);
	            return MessageUtil.newsMessageToXml(newmsg);
	        } catch (Exception e) {
	            System.out.println("====代码有问题额☺！");
	        }
        }
         
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { //取消关注事件
            System.out.println("==============这是取消关注事件！");
        }
         
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SCAN)) { //扫描二维码事件
            System.out.println("==============这是扫描二维码事件！");
        }
         
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_LOCATION)) { //位置上报事件
            System.out.println("==============这是位置上报事件！");
        }
         
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)) { //自定义菜单点击事件
            System.out.println("==============这是自定义菜单点击事件！");
            // 事件KEY值，与创建自定义菜单时指定的KEY值对应  
            String eventKey = (String) map.get("EventKey");  
            String respContent = "";
            if (eventKey.equals("image")) {  
            	respContent = "回复图片菜单项被点击！";  
            }
            TextMessage txtmsg = new TextMessage();  
            txtmsg.setToUserName(openid);
        	txtmsg.setFromUserName(mpid);
        	txtmsg.setCreateTime(new Date().getTime());
        	txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        	txtmsg.setContent(respContent);
            return MessageUtil.textMessageToXml(txtmsg);  
        }
         
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_VIEW)) { //自定义菜单View事件
            System.out.println("==============这是自定义菜单View事件！");
        }
        
        if (map.get("Event").equals("scancode_waitmsg")) {
            List<Element> list = (List<Element>)map.get("ScanCodeInfo");
            for(Element e : list){
                System.out.println(e.getName()+"======"+e.getText());
            }
        }
         
         
        return null;
    }
}
