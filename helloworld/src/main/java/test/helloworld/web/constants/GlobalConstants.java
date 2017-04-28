package test.helloworld.web.constants;

import java.util.Properties;

import test.helloworld.web.start.InterfaceUrlInti;


/**
 * @author Zou Ling
 * @date 2016年9月7日 上午11:19:35
 * @description 配置文件全局变量
 */
public class GlobalConstants {
	 
    public static Properties interfaceUrlProperties;
    static {
        if (GlobalConstants.interfaceUrlProperties == null) {
            InterfaceUrlInti.init();
        }
    }
 
    /**
     * 
     * @Description: 根据不同类型取值
     * @param @param key
     * @param @return
     */
    public static String getString(String key) {
        String Properties = (String) interfaceUrlProperties.get(key);
        return Properties == null ? null : Properties;
    }
 
    public static Integer getInt(String key) {
        String Properties = (String) interfaceUrlProperties.get(key);
        return Properties == null ? null : Integer.parseInt(Properties);
    }
 
    public static Boolean getBoolean(String key) {
        String Properties = (String) interfaceUrlProperties.get(key);
        return Properties == null ? null : Boolean.valueOf(Properties);
    }
 
    public static Long getLong(String key) {
        String Properties = (String) interfaceUrlProperties.get(key);
        return Properties == null ? null : Long.valueOf(Properties);
    }
 
}
