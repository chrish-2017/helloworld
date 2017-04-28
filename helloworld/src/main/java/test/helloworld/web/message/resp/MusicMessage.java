package test.helloworld.web.message.resp;


/**
 * @author Zou Ling
 * @date 2016年9月7日 上午10:22:07
 * @description 音乐消息
 */
public class MusicMessage extends BaseMessage {  
    // 音乐   
    private Music Music;  
   
    public Music getMusic() {  
        return Music;  
    }  
   
    public void setMusic(Music music) {  
        Music = music;  
    }  
}
