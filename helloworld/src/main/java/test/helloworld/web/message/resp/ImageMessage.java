package test.helloworld.web.message.resp;

import test.helloworld.web.message.req.BaseMessage;

/**
 * @author Zou Ling
 * @date 2016年9月7日 上午10:20:54
 * @description 图片消息
 */
public class ImageMessage extends BaseMessage {
    
    private Image Image;
 
    public Image getImage() {
        return Image;
    }
 
    public void setImage(Image image) {
        Image = image;
    }
     
 
}
