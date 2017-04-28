package test.helloworld.web.message.req;


/**
 * @author Zou Ling
 * @date 2016年9月7日 上午9:59:09
 * @description 文本消息
 */
public class TextMessage extends BaseMessage {  
    // 消息内容   
    private String Content;  
   
    public String getContent() {  
        return Content;  
    }  
   
    public void setContent(String content) {  
        Content = content;  
    }  
}
