package test.helloworld.web.message.req;


/**
 * @author Zou Ling
 * @date 2016年9月7日 上午9:57:12
 * @description 图片消息
 */
public class ImageMessage extends BaseMessage {
    // 图片链接
    private String PicUrl;
 
    public String getPicUrl() {
        return PicUrl;
    }
 
    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
