package test.helloworld.web.message.resp;


/**
 * @author Zou Ling
 * @date 2016年9月7日 上午10:17:13
 * @description 文本消息消息体
 */
public class TextMessage extends BaseMessage {  
    // 回复的消息内容   
    private String Content;  
   
    public String getContent() {  
        return Content;  
    }  
   
    public void setContent(String content) {  
        Content = content;  
    }  
}
