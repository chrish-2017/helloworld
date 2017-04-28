package test.helloworld.web.quartz;

import org.apache.log4j.Logger;

import test.helloworld.web.common.WeChatTask;

public class QuartzJob{
    private static Logger logger = Logger.getLogger(QuartzJob.class);
    /**
     * @Description: 任务执行获取token
     * @param    
     */
    public void workForToken() {
        try {
            WeChatTask timer = new WeChatTask();
            timer.getToken_getTicket();
        } catch (Exception e) {
            logger.error(e, e);
        }
    }
 
 
}
