  
/**  
 * 文件名：CommonUtil.java  
 *   
 * 日期：2015年5月18日  
 *  
*/  
    
package test.helloworld.web.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class CommonUtil {
	//bean工厂
	private static ApplicationContext springFactory = null;

	public static Object getBean(String name) {
		return springFactory.getBean(name);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		springFactory = applicationContext;
	}
}
