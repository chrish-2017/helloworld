package test.helloworld.web.menu;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import test.helloworld.web.bean.ClickButton;
import test.helloworld.web.bean.ViewButton;
import test.helloworld.web.constants.GlobalConstants;
import test.helloworld.web.util.HttpUtils;

public class MenuMain {
    public static void main(String[] args) throws Exception {
        
        ClickButton pic_sysphoto=new ClickButton();
        pic_sysphoto.setType("pic_sysphoto");
        pic_sysphoto.setName("系统拍照发图");
        pic_sysphoto.setKey("rselfmenu_1_0");
        ClickButton pic_photo_or_album=new ClickButton();
        pic_photo_or_album.setType("pic_photo_or_album");
        pic_photo_or_album.setName("拍照或者相册发图");
        pic_photo_or_album.setKey("rselfmenu_1_1");
        ClickButton pic_weixin=new ClickButton();
        pic_weixin.setType("pic_weixin");
        pic_weixin.setName("微信相册发图");
        pic_weixin.setKey("rselfmenu_1_2");
         
        JSONArray sub_button=new JSONArray();
        sub_button.add(pic_sysphoto);
        sub_button.add(pic_photo_or_album);
        sub_button.add(pic_weixin);
         
        JSONObject buttonOne=new JSONObject();
        buttonOne.put("name", "发图");
        buttonOne.put("sub_button", sub_button);
        
        ViewButton vbt=new ViewButton();
        vbt.setType("view");
        vbt.setName("注册");
        vbt.setUrl("http://chrish.ngrok.cc/regist.jsp");
        
        JSONArray button=new JSONArray();
        button.add(buttonOne);
        button.add(vbt);
        
        JSONObject menujson=new JSONObject();
        menujson.put("button", button);
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "client_credential");
        params.put("appid", GlobalConstants.getString("appid"));
        params.put("secret", GlobalConstants.getString("AppSecret"));
        String jstoken = HttpUtils.sendGet(
                GlobalConstants.getString("tokenUrl"), params);
        String access_token = JSONObject.fromObject(jstoken).getString(
                "access_token");
        GlobalConstants.interfaceUrlProperties.put("access_token", access_token);
        String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+access_token;
         
        try{
            String rs=HttpUtils.sendPostBuffer(url, menujson.toString());
            System.out.println(rs);
        }catch(Exception e){
            System.out.println("请求错误！");
        }
     
    }

}
