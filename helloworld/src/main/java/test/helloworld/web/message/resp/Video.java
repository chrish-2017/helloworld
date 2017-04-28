package test.helloworld.web.message.resp;


/**
 * @author Zou Ling
 * @date 2016年9月7日 上午10:22:43
 * @description 视频消息体
 */
public class Video {
	 
    private String MediaId;
    private String Title;
    private String Description;
 
    public String getTitle() {
        return Title;
    }
 
    public void setTitle(String title) {
        Title = title;
    }
 
    public String getDescription() {
        return Description;
    }
 
    public void setDescription(String description) {
        Description = description;
    }
 
    public String getMediaId() {
        return MediaId;
    }
 
    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
 
}
